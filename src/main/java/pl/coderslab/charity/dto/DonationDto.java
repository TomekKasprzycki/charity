package pl.coderslab.charity.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDto {

    Long id;
    Integer quantity;
    List<Long> categories_id;
    Long institutionId;
    String city;
    String street;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;

}
