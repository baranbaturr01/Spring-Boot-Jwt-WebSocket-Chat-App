package com.baranbatur.chatapp.service;

import com.baranbatur.chatapp.dto.request.ChairDto;
import com.baranbatur.chatapp.dto.request.RegisterUserDto;
import com.baranbatur.chatapp.entity.*;
import com.baranbatur.chatapp.repository.*;
import com.baranbatur.chatapp.util.TimeSlot;
import com.baranbatur.chatapp.util.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ChairRepository chairRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, ChairRepository chairRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.chairRepository = chairRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User createAdmin(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);
        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = new User();
        user.setEmail(input.getEmail());
        user.setUsername(input.getUsername());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setPhone(input.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setGender(input.gender());
        user.setBirthDate(input.getBirthDate());
        user.setRole(optionalRole.get());
        return userRepository.save(user);

    }

    public List<Shop> getAllShopList() {

        return shopRepository.findAll();
    }

    public ChairDto getShopChairDetailByChairId(long chairId) {
        Chair chair = chairRepository.findById(chairId).orElse(null);
        if (chair != null) {
            ChairDto chairDto = new ChairDto();
            chairDto.setId(chair.getId());
            chairDto.setChairName(chair.getName());
            chairDto.setStartTime(chair.getShop().getStarTime());
            chairDto.setEndTime(chair.getShop().getEndTime());
            chairDto.setAvailabilityIntervals(this.getAvailabilityIntervals());
            return chairDto;
        }
        return null;
    }

    private List<TimeSlot> getAvailabilityIntervals() {
        List<TimeSlot> availabilityIntervals = new ArrayList<>();

        LocalTime startTime = LocalTime.of(9, 0); // Başlangıç saati
        LocalTime endTime = LocalTime.of(18, 0); // Bitiş saati

        while (startTime.isBefore(endTime)) {
            LocalTime nextHour = startTime.plusHours(1);

            // Koltuğun bu saat aralığında rezerve edilip edilmediğini kontrol et
            boolean isReserved = isReservedForTimeSlot(startTime, nextHour);

            TimeSlot timeInterval = new TimeSlot(startTime, nextHour, !isReserved);
            availabilityIntervals.add(timeInterval);

            startTime = nextHour; // Bir sonraki saat aralığına geç
        }

        return availabilityIntervals;
    }

    private boolean isReservedForTimeSlot(LocalTime startTime, LocalTime endTime) {
        // Burada, startTime ve endTime arasında herhangi bir rezervasyon olup olmadığını kontrol et
        List<Reservation> reservations = reservationRepository.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(endTime, startTime);
        return !reservations.isEmpty();
    }
}
