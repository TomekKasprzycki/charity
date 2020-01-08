package pl.coderslab.charity.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    @OneToMany(mappedBy = "institution")
    List<Donation> donations;


}
