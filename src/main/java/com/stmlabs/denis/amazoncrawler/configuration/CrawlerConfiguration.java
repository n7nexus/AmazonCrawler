package com.stmlabs.denis.amazoncrawler.configuration;

import com.stmlabs.denis.amazoncrawler.utils.impl.ContentByDate;
import com.stmlabs.denis.amazoncrawler.utils.impl.ContentByParserId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Date;

@Configuration
public class CrawlerConfiguration {

    @Bean
    @Scope(value = "prototype")
    public ContentByDate contentByDate(Date date) {
        return new ContentByDate(date);
    }

    @Bean
    @Scope(value = "prototype")
    public ContentByParserId contentByParserId(Integer parserId) {
        return new ContentByParserId(parserId);
    }
}
