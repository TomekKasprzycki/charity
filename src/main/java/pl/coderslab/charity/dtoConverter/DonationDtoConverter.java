package pl.coderslab.charity.dtoConverter;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.entities.Donation;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class DonationDtoConverter {

    public Donation convertFromDto(DonationDto donationDto){

        Donation donation = new Donation();

        donation.setId(donationDto.getId());
        donation.setQuantity(donationDto.getQuantity());
        donation.setCategories();
        donation.setCity(donationDto.getCity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        donation.setInstitution(donationDto.getInstitutionId());
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());

        return donation;
    }

    public DonationDto convertToDto(Donation donation){

        DonationDto donationDto = new DonationDto();

        donationDto.setId(donation.getId());

        return donationDto;
    }


}
