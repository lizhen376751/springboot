package com.lizhen.springboot.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * xxl-job 自己写的定时任务
 * Created by lizhen on 2018/4/9 0009.
 * <p>
 * 任务Handler的一个Demo（Bean模式）
 * <p>
 * 开发步骤：
 * 1、继承 “IJobHandler” ；
 * 2、装配到Spring，例如加 “@Service” 注解；
 * 3、加 “@JobHander” 注解，注解value值为新增任务生成的JobKey的值;多个JobKey用逗号分割;
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 */
@Service
@JobHander("myjobhandler")
public class MyJobHandler extends IJobHandler {

    @Value("${xxl.job.executor.port}")
    private String port;

    @Override
    public ReturnT<String> execute(String... strings) throws Exception {
        System.out.println("定时任务调度成功===="+strings[0]+"===="+strings[1]+"=========="+strings[2]+"======+port：" + port);
        ReturnT.SUCCESS.setContent("success good good");
        ReturnT.SUCCESS.setMsg("hello word!");
        return ReturnT.SUCCESS;
    }
}
