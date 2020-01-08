package pl.coderslab.charity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.repositories.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    public List<Donation> getDonationsByInstitution(Long id){return donationRepository.findDonationByInstitutionId(id); }

}
