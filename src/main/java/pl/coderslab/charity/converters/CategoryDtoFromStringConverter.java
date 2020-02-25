package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dtoConverter.CategoryDtoConverter;
import pl.coderslab.charity.services.CategoryService;

public class CategoryDtoFromStringConverter implements Converter<String, CategoryDto> {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDtoConverter categoryDtoConverter;

    @Override
    public CategoryDto convert(String s) {
        return categoryDtoConverter.convertToDto(categoryService.getCategoryById(Long.parseLong(s)));
    }
}
