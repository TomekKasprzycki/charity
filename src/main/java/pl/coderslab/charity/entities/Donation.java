package pl.coderslab.charity.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Integer quantity;
    @ManyToMany
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    List<Category> categories;
    @ManyToOne
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    Institution institution;
    String city;
    String street;
    String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
    String phoneNumber;


}
