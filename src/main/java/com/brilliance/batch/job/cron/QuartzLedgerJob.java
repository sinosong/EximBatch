package com.brilliance.batch.job.cron;

import com.brilliance.batch.util.SpringContextHolder;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

@Component("quartzLedgerJob")
public class QuartzLedgerJob  {

    private static final Logger logger = LoggerFactory.getLogger(QuartzLedgerJob .class);

    private static long counter = 0L;

    /**
     * 执行业务方法
     * @throws Exception
     */
    public void execute() throws Exception {
        logger.info("start...");
        ApplicationContext context = SpringContextHolder.getApplicationContext();

        System.out.println("****************************");
        StopWatch sw = new StopWatch();
        sw.start();
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
        /*
         * Spring Batch Job同一个job instance，成功执行后是不允许重新执行的【失败后是否允许重跑，
         * 可通过配置Job的restartable参数来控制，默认是true】，如果需要重新执行，可以变通处理，
         * 添加一个JobParameters构建类,以当前时间作为参数，保证其他参数相同的情况下却是不同的job instance
         */
        /*jobParameterBulider.addDate("date", new Date());
        jobLauncher.run(ledgerJob, jobParameterBulider.toJobParameters());*/

        sw.stop();
        logger.debug("Time elapsed:{},Execute quartz ledgerJob:{}", sw.prettyPrint(), ++counter);
    }

}
