package com.brilliance.batch.work.run;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class JobLauncherBuilder extends SimpleJobLauncher {


    public static void main(String[] args) {

        String[] springConfig =
                {
//                        "batch/jobs/job-hello-world.xml"
                        "batch/jobs/job-read-table.xml"
                };

        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("readTable");

        try {

            Date date = new Date();
            JobExecution execution = jobLauncher.run(job,new JobParametersBuilder()
                    .addDate("date", date)
                    .addString("workdate", "2029-04-12 00:00:00")
                    .addString("bizcode","CRP2019040033001")
                    .addString("outputFilePath", "G:/temp/test/"+ DateFormatUtils.format(date,"yyyyMMDDHHmmss")+".xml")
                    .toJobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }


}
