package com.codewater.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： CodeWater
 * @create ：2022-07-22-15:00
 * @Function Description ：
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
//       //==========================模拟流控模式：线程数。开两个窗口访问============================
//        try{
//            TimeUnit.MILLISECONDS.sleep( 800 );
//        }catch( InterruptedException e){
//            e.printStackTrace();
//        }
        
        return "==========================testA============================";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + ".....testB" );
        return "==========================testB============================";
    }

    @GetMapping("/testD")
    public String testD(){
        //==========================测试降级：Rt============================
//        try{
//            TimeUnit.SECONDS.sleep(1);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }

        //==========================测试降级：异常比例============================
        log.info(("testD: 异常比例"));
        int age = 1 / 0 ;
        return "==========================testD============================";
    }
    
    @GetMapping("/testE")
    public String testE(){
        log.info("testE测试异常数");
        int age = 10 / 0;
        return "----------------testE 测试异常数";
    }

    /**热点key限流
     * @SentinelResource 中的value是跟sentinel中热点规则的资源名保持一致，blockHandler设置处理的异常方法
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value="testHotKey" , blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1" , required = false) String p1 ,
                             @RequestParam(value = "p2" , required = false) String p2 ){
        return "----------testHotKey";
    }
//    自定义异常处理方法,就不会出现原始的Blocked by Sentinel (flow limiting)
    public String deal_testHotKey(String p1 , String p2 , BlockException exception ){
        
        return "--------deal_testHotKey,o(╥﹏╥)o---------";
    }
}
