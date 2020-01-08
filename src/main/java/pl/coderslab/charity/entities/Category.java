package pl.coderslab.charity.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "donation_id", referencedColumnName = "id")
    Donation donation;


}
