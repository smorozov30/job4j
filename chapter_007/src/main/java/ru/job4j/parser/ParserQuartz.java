package ru.job4j.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ParserQuartz {
    private Config config;

    public ParserQuartz(Config config) {
        this.config = config;
    }

    public void start() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = newJob(ParserSQLRu.class)
                .withIdentity("pars")
                .build();
        Trigger trigger = newTrigger()
                .withIdentity("trigger", "group")
                .withSchedule(cronSchedule(config.get("cron.time")))
                .forJob(job)
                .build();
        scheduler.scheduleJob(job, trigger);
    }
}
