package pl.coderslab.charity.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    @ManyToMany(mappedBy = "categories")
    //@JoinColumn(name = "donation_id", referencedColumnName = "id")
    List<Donation> donations;


}
