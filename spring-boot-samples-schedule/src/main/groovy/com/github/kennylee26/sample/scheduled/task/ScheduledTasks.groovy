package com.github.kennylee26.sample.scheduled.task

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.text.SimpleDateFormat

/**
 * <p> 任务调度 </p>
 * <p>Created on 28/4/15.</p>
 * @author kennylee
 */
@Component
class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = '${task.cron}')
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
