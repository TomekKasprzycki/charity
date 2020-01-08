package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.Institution;

@Repository
@Transactional
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
