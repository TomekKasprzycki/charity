package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.repositories.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    private DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository){
        this.donationRepository=donationRepository;
    }

    public List<Donation> getDonationsByInstitution(Long id){return donationRepository.findDonationByInstitutionId(id); }

    public Donation getDonationById(Long donationId) {
        return donationRepository.findDonationById(donationId);
    }

    public List<Donation> getDonationsByListId(List<Long> donations_id) {
        return donationRepository.findAllById(donations_id);
    }

    public long getNumberOfBags() {
        return donationRepository.countAllDonations();
    }

    public void saveDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public Long getLastId() {
        return donationRepository.findLastId();
    }
}
