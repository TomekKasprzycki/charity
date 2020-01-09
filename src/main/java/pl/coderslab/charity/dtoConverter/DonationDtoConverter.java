package pl.coderslab.charity.dtoConverter;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.services.InstitutionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonationDtoConverter {

    private InstitutionService institutionService;

    public DonationDtoConverter(InstitutionService institutionService){
        this.institutionService=institutionService;
    }

    public Donation convertFromDto(DonationDto donationDto){

        Donation donation = new Donation();

        donation.setId(donationDto.getId());
        donation.setQuantity(donationDto.getQuantity());
        //donation.setCategories();
        donation.setCity(donationDto.getCity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        donation.setInstitution(institutionService.getInstitutionByDonationId(donationDto.getInstitutionId()));
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());

        return donation;
    }

    public DonationDto convertToDto(Donation donation){

        DonationDto donationDto = new DonationDto();

        donationDto.setId(donation.getId());
        donationDto.setQuantity(donation.getQuantity());
        //donationDto.setCategories();
        donationDto.setCity(donation.getCity());
        donationDto.setStreet(donation.getStreet());
        donationDto.setZipCode(donation.getZipCode());
        donationDto.setInstitutionId(donation.getInstitution().getId());
        donationDto.setPickUpComment(donation.getPickUpComment());
        donationDto.setPickUpDate(donation.getPickUpDate());
        donationDto.setPickUpTime(donation.getPickUpTime());
        return donationDto;
    }

    public List<Donation> convertFromDto(List<DonationDto> donationDtoList){

        List<Donation> donations = new ArrayList<>();

        for(DonationDto donationDto : donationDtoList){
            donations.add(convertFromDto(donationDto));
        }

        return donations;
    }

    public List<DonationDto> convertToDto(List<Donation> donations){

        List<DonationDto> donationDtoList = new ArrayList<>();

        for(Donation donation : donations){
            donationDtoList.add(convertToDto(donation));
        }

        return donationDtoList;
    }

}
