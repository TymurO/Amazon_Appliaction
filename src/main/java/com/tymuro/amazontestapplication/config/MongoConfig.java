package com.tymuro.amazontestapplication.config;

import com.tymuro.amazontestapplication.converters.ReadingConverter;
import com.tymuro.amazontestapplication.converters.WritingConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new WritingConverter());
        converterList.add(new ReadingConverter());

        return new MongoCustomConversions(converterList);
    }
}
