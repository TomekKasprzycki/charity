package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.dtoConverter.InstitutionDtoConverter;
import pl.coderslab.charity.services.InstitutionService;

public class InstitutionDtoFromStringConverter implements Converter<String, InstitutionDto> {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private InstitutionDtoConverter institutionDtoConverter;

    @Override
    public InstitutionDto convert(String s) {
        return institutionDtoConverter.convertToDto(institutionService.getInstitutionById(Long.parseLong(s)));
    }

}
