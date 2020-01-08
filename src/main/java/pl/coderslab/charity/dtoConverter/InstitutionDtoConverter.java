package pl.coderslab.charity.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.DonationService;

@Service
public class InstitutionDtoConverter {

    @Autowired
    DonationService donationService;

    public Institution convertFromDto(InstitutionDto institutionDto){

        Institution institution = new Institution();

        institution.setId(institutionDto.getId());
        institution.setName(institutionDto.getName());
        institution.setDescription(institutionDto.getDescription());
        institution.setDonations();

        return institution;
    }

    public InstitutionDto convertToDto(Institution institution){

        InstitutionDto institutionDto = new InstitutionDto();

        institutionDto.setId(institution.getId());
        institutionDto.setName(institution.getName());
        institutionDto.setDescription(institution.getDescription());
        institutionDto.setDonations_id();

    }

}
