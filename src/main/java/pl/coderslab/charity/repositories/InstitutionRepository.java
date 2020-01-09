package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.Institution;

@Repository
@Transactional
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query(value = "select * from institution inner join donation on institution.id=donation.institution_id " +
            "where donation.institution_id=:donation_id", nativeQuery = true)
    Institution findInstitutionByDonationId(@Param("donation_id") Long donation_id);
}
