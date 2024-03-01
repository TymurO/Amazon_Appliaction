package com.tymuro.amazontestapplication.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

@org.springframework.data.convert.WritingConverter
public class WritingConverter implements Converter<LocalDate, String> {

    @Override
    public String convert(LocalDate source) {
        return source.toString();
    }
}
