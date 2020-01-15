package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository){
        this.institutionRepository=institutionRepository;
    }

    public Institution getInstitutionByDonationId(Long donation_id){
        return institutionRepository.findInstitutionByDonationId(donation_id);
    }

    public List<Institution> getSupportedInstitutions(List<Long> idList) {
        return institutionRepository.findSupportedInstitutions(idList);
    }

    public Institution getInstitutionById(Long id) {
        return institutionRepository.findInstitutionById(id);
    }

    public List<Long> getIdListOfSupportedInstitutions(){
        return institutionRepository.findIdListOfSupportedInstitutions();
    }
}
