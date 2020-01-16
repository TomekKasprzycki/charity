package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Service
public class DonationDto {

    Long id;
    Integer quantity;
    List<Long> categoriesId;
    Long institutionId;
    String city;
    String street;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
    String phoneNumber;

}
