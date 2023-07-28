package com.solvedex.BlogSolvedex.config;

import com.solvedex.BlogSolvedex.conversion.DomainToCommentDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@RequiredArgsConstructor
public class ConverterConfiguration {



    /**
     * Conversion configuration service.
     *
     * @return Config configuration context
     */
    @Bean
    @Primary
    public ConversionService conversionService() {
        var conversionService = new DefaultConversionService();

        conversionService.addConverter(new DomainToCommentDtoConverter());
        conversionService.addConverter(new DomainToCommentDtoConverter());
        return conversionService;
    }
}