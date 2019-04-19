package com.brilliance.batch.sample.config;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(modular=true)
public class JobConfiguration {

    @Bean
    public ApplicationContextFactory oneJob(){
        return new GenericApplicationContextFactory(JobOneConfiguration.class);
    }

}
