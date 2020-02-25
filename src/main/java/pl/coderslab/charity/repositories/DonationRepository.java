package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entities.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findDonationByInstitutionId(Long id);

    Donation findDonationById(Long id);

    @Query("select count(d) from Donation d")
    long countAllDonations();

    @Query(value = "SELECT max(id) as maxelement FROM donation", nativeQuery = true)
    Long findLastId();
}
