package com.brilliance.batch.work.run;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class StartQuartz {

    public static void main(String[] args) throws FileNotFoundException {

        new ClassPathXmlApplicationContext("batch/jobs/job-quartz.xml");
    }

}
