package com.brilliance.batch.sample.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import java.util.List;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class JobOneConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobOne() {
        return jobBuilderFactory.get("jobOne")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public JdbcCursorItemReader<Map<String, String>> reader() {
        JdbcCursorItemReader<Map<String, String>> reader = new JdbcCursorItemReader();
        //reader逻辑根据实际需要写，先不举例
        return reader;
    }

    public ItemProcessor<Map<String, String>, String> tableProcessor() {
        return new ItemProcessor<Map<String, String>, String>() {
            @Override
            public String process(Map<String, String> map) throws Exception {
                String insertSql = "";
                //process逻辑根据实际需要写，先不举例
                return insertSql;
            }
        };
    }

    @Bean
    public ItemWriter<String> writer() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> list) throws Exception {
                //writer逻辑根据实际需要写，先不举例
            }
        };
    }

    //step
    @Bean
//    @JobScope
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Map<String, String>, String>chunk(100)
                .reader(reader())
                .processor(tableProcessor())
                .writer(writer())
                .build();
    }

}
