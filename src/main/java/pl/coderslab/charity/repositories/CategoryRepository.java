package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findCategoryById(Long id);
}
