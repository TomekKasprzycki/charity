package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.converters.InstitutionConverter;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.dtoConverter.InstitutionDtoConverter;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private DonationService donationService;
    private InstitutionService institutionService;
    private InstitutionDtoConverter institutionDtoConverter;

    public HomeController(DonationService donationService, InstitutionDtoConverter institutionDtoConverter,
                          InstitutionService institutionService){
        this.donationService = donationService;
        this.institutionDtoConverter = institutionDtoConverter;
        this.institutionService = institutionService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){

        long numberOfBags = donationService.getNumberOfBags();
        long numberOfSupportedInstitutions = institutionService.getIdListOfSupportedInstitutions().size();
        List<InstitutionDto> supportedInstitutions = institutionDtoConverter.convertToDto(institutionService.getAll());
        model.addAttribute("allBags", numberOfBags);
        model.addAttribute("numberOfSupportedInstitutions", numberOfSupportedInstitutions);
        model.addAttribute("supportedInstitutions", supportedInstitutions);

        return "index";
    }
}
