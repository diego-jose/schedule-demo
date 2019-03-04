package com.ciandt.poc.h2.demoh2.com.ciandt.poc.h2.demoh2.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class ScheduleManager {

    @Autowired
    private TaskJob job;

    @Scheduled(cron = "0/30 * * * * *")
    public void scheduleTaskUsingCronExpression() {

        job.run();

    }
}
