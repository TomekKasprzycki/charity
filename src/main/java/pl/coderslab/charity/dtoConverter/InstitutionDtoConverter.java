package pl.coderslab.charity.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.DonationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionDtoConverter {

    private DonationService donationService;

    public InstitutionDtoConverter(DonationService donationService){
        this.donationService = donationService;
    }

    public Institution convertFromDto(InstitutionDto institutionDto){

        Institution institution = new Institution();

        institution.setId(institutionDto.getId());
        institution.setName(institutionDto.getName());
        institution.setDescription(institutionDto.getDescription());
        institution.setDonations(donationService.getDonationsByListId(institutionDto.getDonations_id()));

        return institution;
    }

    public InstitutionDto convertToDto(Institution institution){

        InstitutionDto institutionDto = new InstitutionDto();

        institutionDto.setId(institution.getId());
        institutionDto.setName(institution.getName());
        institutionDto.setDescription(institution.getDescription());
            List<Long> donations_id = new ArrayList<>();
            for(Donation donation : institution.getDonations()){
                donations_id.add(donation.getId());
            }
        institutionDto.setDonations_id(donations_id);

        return institutionDto;
    }

    public List<Institution> convertFromDto(List<InstitutionDto> institutionDtoList){

        List<Institution> institutions = new ArrayList<>();

        for (InstitutionDto institutionDto : institutionDtoList){
            institutions.add(convertFromDto(institutionDto));
        }

        return institutions;
    }

    public List<InstitutionDto> convertToDto(List<Institution> institutions){

        List<InstitutionDto> institutionDtoList = new ArrayList<>();

        for (Institution institution : institutions){
            institutionDtoList.add(convertToDto(institution));
        }

        return institutionDtoList;
    }


}
