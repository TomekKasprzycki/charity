package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CategoryDto {

    Long id;
    String name;
    String description;

}
