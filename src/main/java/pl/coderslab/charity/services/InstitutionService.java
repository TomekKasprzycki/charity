package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

@Service
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository){
        this.institutionRepository=institutionRepository;
    }

    public Institution getInstitutionByDonationId(Long donation_id){
        return institutionRepository.findInstitutionByDonationId(donation_id);
    }


}
