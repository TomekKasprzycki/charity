package pl.coderslab.charity.dtoConverter;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.services.DonationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonationDtoConverter {

    private CategoryDtoConverter categoryDtoConverter;
    private InstitutionDtoConverter institutionDtoConverter;
    private DonationService donationService;

    public DonationDtoConverter(
            CategoryDtoConverter categoryDtoConverter,
            InstitutionDtoConverter institutionDtoConverter,
            DonationService donationService
    ){
        this.categoryDtoConverter = categoryDtoConverter;
        this.institutionDtoConverter = institutionDtoConverter;
        this.donationService = donationService;
    }

    public Donation convertFromDto(DonationDto donationDto){

        Donation donation = new Donation();

        Long dtoId = donationDto.getId();

        if (dtoId!=null) {
            donation.setId(dtoId);
        } else {
            Long newId = donationService.getLastId()+1;
            donation.setId(newId);
        }
        donation.setQuantity(donationDto.getQuantity());
            List<Category> categories = categoryDtoConverter.convertFromDto(donationDto.getCategoryDto());
        donation.setCategories(categories);
        donation.setCity(donationDto.getCity());
        donation.setStreet(donationDto.getStreet());
        donation.setZipCode(donationDto.getZipCode());
        donation.setInstitution(institutionDtoConverter.convertFromDto(donationDto.getInstitutionDto()));
        donation.setPickUpComment(donationDto.getPickUpComment());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPhoneNumber(donationDto.getPhoneNumber());

        return donation;
    }

    public DonationDto convertToDto(Donation donation){

        DonationDto donationDto = new DonationDto();

        donationDto.setId(donation.getId());
        donationDto.setQuantity(donation.getQuantity());
            List<CategoryDto> categoryDtoList = categoryDtoConverter.convertToDto(donation.getCategories());
        donationDto.setCategoryDto(categoryDtoList);
        donationDto.setCity(donation.getCity());
        donationDto.setStreet(donation.getStreet());
        donationDto.setZipCode(donation.getZipCode());
        donationDto.setInstitutionDto(institutionDtoConverter.convertToDto(donation.getInstitution()));
        donationDto.setPickUpComment(donation.getPickUpComment());
        donationDto.setPickUpDate(donation.getPickUpDate());
        donationDto.setPickUpTime(donation.getPickUpTime());
        donationDto.setPhoneNumber(donation.getPhoneNumber());
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
