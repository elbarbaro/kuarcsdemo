package com.barbaro.kuarcsdemo.config;

import com.barbaro.kuarcsdemo.jobs.RequestAPIJob;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(RequestAPIJob.class)
            .withIdentity("myJob", "group1")
            .storeDurably(true)
            .build();
    }

    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
            .withIdentity("trigger3", "group1")
            .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
            .forJob("myJob", "group1")
            .build();
    }
}
