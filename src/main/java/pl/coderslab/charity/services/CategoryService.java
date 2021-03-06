package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesById(List<Long> categoriesId) {
        return categoryRepository.findAllById(categoriesId);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }
}
