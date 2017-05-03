package com.duan.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Aduan
 * 2017/4/25 9:33.
 */
@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count0 = 1;
    private Integer count1 = 1;
    private Integer count2 = 1;

    /**
     * 每3秒执行一次任务 -- 打印当前时间
     */
    //@Scheduled(fixedRate = 3000)
    public void reportCurrentTime() throws InterruptedException {
        log.info(String.format("---第%s次执行，当前时间为：%s",count0++,dateFormat.format(new Date())));
    }

    /**
     * 延迟5秒执行一次任务 -- 打印当前时间
     */
    //@Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeAfterSleep() throws InterruptedException {
        log.info(String.format("===第%s次执行，当前时间为：%s", count1++, dateFormat.format(new Date())));
    }

    /**
     * 每分钟执行一次任务 -- 打印当前时间
     */
    //@Scheduled(cron = "* */1 * * * *")
    public void reportCurrentTimeCron() throws InterruptedException {
        log.info(String.format("+++第%s次执行，当前时间为：%s", count2++, dateFormat.format(new Date())));
    }
}
