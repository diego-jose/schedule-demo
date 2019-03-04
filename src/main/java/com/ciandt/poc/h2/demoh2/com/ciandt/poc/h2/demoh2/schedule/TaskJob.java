package com.ciandt.poc.h2.demoh2.com.ciandt.poc.h2.demoh2.schedule;

import org.springframework.stereotype.Component;

@Component
public class TaskJob implements Runnable {
    @Override
    public void run() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
