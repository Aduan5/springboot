package com.duan.controller;

import com.duan.domain.Result;
import com.duan.service.DemoAsyncService;
import com.duan.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * Created by Aduan
 * 2017/4/25 10:03.
 */
@RestController
@RequestMapping(value = "/async")
public class DemoAsyncController {
    private static final Logger log = LoggerFactory.getLogger(DemoAsyncController.class);
    @Resource
    private DemoAsyncService demoAsyncService;

    /**
     * 测试异步方法调用顺序
     */
    //@ApiOperation(value="测试异步方法调用顺序", notes="getEntityById")
    @RequestMapping(value = "/getTestDemoAsync", method = RequestMethod.GET)
    public Result<String> getEntityById() throws Exception {

        long start = System.currentTimeMillis();

        demoAsyncService.doTaskOne();
        Future<String> task2 = demoAsyncService.doTaskTwo();
        Future<String> task3 = demoAsyncService.doTaskThree();

        while(true) {
            if(task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                log.info("任务二完成返回值：{}",task2.get() );
                log.info("任务三完成返回值：{}",task3.get() );
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务二、三全部完成，总耗时：" + (end - start) + "毫秒");
        return ResultUtil.success();
    }
}
