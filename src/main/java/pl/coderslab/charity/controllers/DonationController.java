package pl.coderslab.charity.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.dtoConverter.CategoryDtoConverter;
import pl.coderslab.charity.dtoConverter.DonationDtoConverter;
import pl.coderslab.charity.dtoConverter.InstitutionDtoConverter;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonationController {

    private CategoryDto categoryDto;
    private CategoryService categoryService;
    private CategoryDtoConverter categoryDtoConverter;
    private DonationDto donationDto;
    private DonationService donationService;
    private DonationDtoConverter donationDtoConverter;
    private InstitutionDto institutionDto;
    private InstitutionService institutionService;
    private InstitutionDtoConverter institutionDtoConverter;

    public DonationController(
            CategoryDto categoryDto,
            CategoryService categoryService,
            CategoryDtoConverter categoryDtoConverter,
            DonationDto donationDto,
            DonationService donationService,
            DonationDtoConverter donationDtoConverter,
            InstitutionDto institutionDto,
            InstitutionService institutionService,
            InstitutionDtoConverter institutionDtoConverter
    ) {
        this.categoryDto = categoryDto;
        this.categoryService = categoryService;
        this.categoryDtoConverter = categoryDtoConverter;
        this.donationDto = donationDto;
        this.donationService = donationService;
        this.donationDtoConverter = donationDtoConverter;
        this.institutionDto = institutionDto;
        this.institutionService = institutionService;
        this.institutionDtoConverter = institutionDtoConverter;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showDonationForm(Model model){

        List<CategoryDto> categoryDtoList = categoryDtoConverter.convertToDto(categoryService.getAllCategories());
        model.addAttribute("categoryDtoList", categoryDtoList);
        List<InstitutionDto> institutionDtoList = institutionDtoConverter.convertToDto(institutionService.getAll());
        model.addAttribute("institutionDtoList", institutionDtoList);
        model.addAttribute("donationDto", new DonationDto());

        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String saveDonationForm(DonationDto donationDto){
        Donation donation = donationDtoConverter.convertFromDto(donationDto);

        donationService.saveDonation(donation);
        return "form-confirmation";
    }

}
