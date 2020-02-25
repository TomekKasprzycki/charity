package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Service
public class DonationDto {

    Long id;
    Integer quantity;
    List<CategoryDto> categoryDto;
    InstitutionDto institutionDto;
    String city;
    String street;
    String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
    String phoneNumber;

}
