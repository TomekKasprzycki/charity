package pl.coderslab.charity.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.services.DonationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDtoConverter {

    private DonationService donationService;

    public CategoryDtoConverter(DonationService donationService){
        this.donationService=donationService;
    }

    public Category convertFromDto(CategoryDto categoryDto){

        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    public CategoryDto convertToDto(Category category){

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());

        return categoryDto;
    }

    public List<Category> convertFromDto(List<CategoryDto> categoryDtoList){

        List<Category> categories = new ArrayList<>();

        for (CategoryDto categoryDto : categoryDtoList){
            categories.add(convertFromDto(categoryDto));
        }

        return categories;
    }

    public List<CategoryDto> convertToDto(List<Category> categories){

        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categories){
            categoryDtoList.add(convertToDto(category));
        }

        return categoryDtoList;
    }

}
