package pl.coderslab.charity.dto;

import lombok.Data;

import java.util.List;

@Data
public class InstitutionDto {

    Long id;
    String name;
    String description;
    List<Long> donations_id;

}
