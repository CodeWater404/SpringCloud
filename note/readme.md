[toc]



# SpringCloud

> 学习springcloud， 参考B站尚硅谷，侵删。
>
> `×`表示官方不再维护

1. 详细的版本依赖[查看](https://start.spring.io/actuator/info)

2. 整个内容

   ![image-20220716181552923](pictures/image-20220716181552923.png)







## 支付模块Payment

服务提供方

> `cloud-provider-payment-8001-8002`：选用`eureka`
>
> `cloud-provider-payment-8004`：选用`zookeeper`
>
> `cloud-providerconsul-payment-8006`：选用`consul`
>
> `cloud-provider-hystrix-payment8001`：`eureka`中心，`hystrix`服务降级、熔断、限流

![image-20220702222351094](pictures/image-20220702222351094.png)

> 浏览器无法直接发送post，可以选用postman测试。
>
> 开发阶段可以采用热部署，上线就不要了





## 消费者模块Consumer

服务调用方

> `cloud-consumer-order80`:使用`eureka`
>
> `cloud-consumerzk-order80`:使用`zookeeper`
>
> `cloud-consumerconsul-order80`:使用`consul`
>
> `cloud-consumer-feign-hystrix-order80`：`eureka`中心，`hystrix`服务降级、熔断、限流
>
> `cloud-consumer-hystrix-dashboard9001`：`eureka`中心，`hystrix`仪表盘

![image-20220714201934827](pictures/image-20220714201934827.png)





## cloud-api-commons

* 抽取公共代码

别的`module`要引用只需要在`pom.xml`中引入依赖即可

```xml
<!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.codewater.com.codewater.com.codewater.com.codewater.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
```





## 服务注册中心



![image-20220714214132360](pictures/image-20220714214132360.png)





### Eureka

> `cloud-eureka-server-7001-7002`



#### 架构

![image-20220714214949448](pictures/image-20220714214949448.png)

* dubbo

  ![image-20220714215043994](pictures/image-20220714215043994.png)

  



#### 集群

![image-20220714231406813](pictures/image-20220714231406813.png)

服务中心互相观察

1. 搭建

   ![image-20220714223529990](pictures/image-20220714223529990.png)

2. 需要本机的`hosts`文件

   ![image-20220714224214787](pictures/image-20220714224214787.png)

   ![image-20220714224219877](pictures/image-20220714224219877.png)

3. 成功（注意看地址栏），也不会爆红了

   ![image-20220714225224873](pictures/image-20220714225224873.png)

   > `eureka`自我保护机制
   >
   > 可以设置关闭，默认是开启的

   ![image-20220715005943482](pictures/image-20220715005943482.png)

   ![image-20220715140356055](pictures/image-20220715140356055.png)

   

4. 支付模块也搭一个集群





### Zookeeper

> [官网下载](http://archive.apache.org/dist/zookeeper)
>
> 参看我的博客[安装](https://www.cnblogs.com/CodeWater404/p/16482043.html)
>
> 没有图形管理界面



#### 架构

![image-20220715171412752](pictures/image-20220715171412752.png)





### Consul

![image-20220715181337515](pictures/image-20220715181337515.png)

![image-20220715181419450](pictures/image-20220715181419450.png)

> [官网下载](https://www.consul.io/downloads)



#### 安装启动

1. 启动，在安装目录下，cmd

   ![image-20220715182533339](pictures/image-20220715182533339.png)

   ![image-20220715182618575](pictures/image-20220715182618575.png)

2. 访问

   ![image-20220715182546969](pictures/image-20220715182546969.png)

   ![image-20220715182654097](pictures/image-20220715182654097.png)







### Nacos

![image-20220720232709282](pictures/image-20220720232709282.png)



#### 注册中心

自带负载均衡





#### 配置中心

自动刷新，不需要别的配置



##### 命名空间

![image-20220721173829979](pictures/image-20220721173829979.png)

![image-20220721173938786](pictures/image-20220721173938786.png)

![image-20220721174001504](pictures/image-20220721174001504.png)

![image-20220721174411329](pictures/image-20220721174411329.png)



1. ![image-20220721180617268](pictures/image-20220721180617268.png)

2. ![image-20220721180716920](pictures/image-20220721180716920.png)

   



#### 集群和持久化

![image-20220721181436342](pictures/image-20220721181436342.png)







### 三个服务中心异同点

![image-20220715212551463](pictures/image-20220715212551463.png)

![image-20220720233147206](pictures/image-20220720233147206.png)







## 服务调用

![image-20220716134846848](pictures/image-20220716134846848.png)

![image-20220716134450888](pictures/image-20220716134450888.png)

> 本地的负载均衡：进程内LB（Ribbon）
>
> ![image-20220716134754612](pictures/image-20220716134754612.png)
>
> 服务端的负载均衡：集中式LB（Nginx）
>
> ![image-20220716134742406](pictures/image-20220716134742406.png)





### Ribbon



#### 架构

![image-20220716134945277](pictures/image-20220716134945277.png)

![image-20220716135039877](pictures/image-20220716135039877.png)



![image-20220716135021294](pictures/image-20220716135021294.png)

![image-20220716141303350](pictures/image-20220716141303350.png)

> 也就是选择一个负载均衡的调用算法。





#### RestTemplate

1. 大概

   ![image-20220716135953542](pictures/image-20220716135953542.png)

2. `getForObject`和`getForEntity`

   ![image-20220716135924187](pictures/image-20220716135924187.png)





### LoadBalancer

在`cloud-consumer-order80`中有个`lb`包下面手写了一个负载均衡轮询的算法





## 服务调用2





### Feign×

不用研究



### OpenFeign

![image-20220716172609830](pictures/image-20220716172609830.png)

==用在消费端==

直接用一个接口+一个注解远程调用，不像Ribbon+restTemplate才能调







## 服务降级

![image-20220716181833302](pictures/image-20220716181833302.png)







### Hystrix×

断路器

停更。。。。。

![image-20220716181845133](pictures/image-20220716181845133.png)

![image-20220716181937170](pictures/image-20220716181937170.png)



#### 相关概念



![image-20220716182356919](pictures/image-20220716182356919.png)



#### 压力测试

用Jmeter



#### 服务降级

![image-20220717174421422](pictures/image-20220717174421422.png)

1. 服务端降级
2. 客户端降级（一般在这边设计）

![image-20220717172041422](pictures/image-20220717172041422.png)

3. 容易出现呢代码膨胀，需要弄一个全局配置

   ![image-20220717172321065](pictures/image-20220717172321065.png)

4. 在消费者这边调用远程服务的接口这里设置（进一步解耦）

   ![image-20220717173040338](pictures/image-20220717173040338.png)

   ![image-20220717173526740](pictures/image-20220717173526740.png)

   



#### 服务熔断

![image-20220717174434409](pictures/image-20220717174434409.png)

![image-20220717174519645](pictures/image-20220717174519645.png)

`@HystrixCommand`

![image-20220717174655108](pictures/image-20220717174655108.png)

> 错误服务次数到达一定数后，所有服务都不可访问；但是当`部分正确服务`到达一定量后（有个调用成功的比例），所有服务就`会恢复`！！
>
> ```java
> //==========================服务熔断============================
>     @HystrixCommand(fallbackMethod="paymentCircuitBreaker_fallback" , commandProperties={
>             @HystrixProperty(name="circuitBreaker.enabled" , value="true" ), // 是否开启断路器
>             @HystrixProperty(name="circuitBreaker.requestVolumeThreshold" , value="10" ), // 请求次数
>             @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds" , value="10000" ),// 时间窗口期
>             @HystrixProperty(name="circuitBreaker.errorThresholdPercentage" , value="true" ),// 失败率达到多少后跳闸
>     })
> 
> ```

![image-20220717181603042](pictures/image-20220717181603042.png)

![image-20220717181741285](pictures/image-20220717181741285.png)

![image-20220717181858473](pictures/image-20220717181858473.png)

![image-20220717181932406](pictures/image-20220717181932406.png)





#### 服务限流

> 具体看alibaba的`sentinel`





#### DashBoard

仪表盘：

`@EnableHystrixDashboard`

![image-20220717184106268](pictures/image-20220717184106268.png)

![image-20220717215559962](pictures/image-20220717215559962.png)

1. 主启动类需要配置

   ```java
   /**
        *此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
        *ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，
        *只要在自己的项目里配置上下面的servlet就可以了
        */
       @Bean
       public ServletRegistrationBean getServlet() {
           HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
           ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
           registrationBean.setLoadOnStartup(1);
           registrationBean.addUrlMappings("/hystrix.stream");
           registrationBean.setName("HystrixMetricsStreamServlet");
           return registrationBean;
       }
   ```

2. 访问地址样例：http://localhost:8001/hystrix.stream

   ![image-20220717215809800](pictures/image-20220717215809800.png)

3. 访问成功的页面

   ![image-20220717215908938](pictures/image-20220717215908938.png)

4. 访问错误的

   ![image-20220717220126030](pictures/image-20220717220126030.png)

   





### resilience4j

少用



### sentinel

常用





## 服务网关





### Zuul×

过期

![image-20220718124433489](pictures/image-20220718124433489.png)

![image-20220718124802228](pictures/image-20220718124802228.png)



### Zuul2

过期



### Gateway



#### 概述

![image-20220718123647654](pictures/image-20220718123647654.png)

![image-20220718123902569](pictures/image-20220718123902569.png)

![image-20220718124107405](pictures/image-20220718124107405.png)

![image-20220718124245574](pictures/image-20220718124245574.png)

![image-20220718124534170](pictures/image-20220718124534170.png)

#### 路由

![image-20220718124956396](pictures/image-20220718124956396.png)





#### 断言

![image-20220718125048324](pictures/image-20220718125048324.png)





#### 过滤

![image-20220718125100481](pictures/image-20220718125100481.png)

![image-20220718141318422](pictures/image-20220718141318422.png)

> 自定义
>
> ![image-20220718141446407](pictures/image-20220718141446407.png)





#### 访问

![image-20220718132312591](pictures/image-20220718132312591.png)

* 配置：

  ```yml
  routes:
          - id: payment_routh #payment_route    #路由的ID，没有固定规则但要求唯一，建议配合服务名
            uri: http://localhost:8001          #匹配后提供服务的路由地址
            predicates: # 断言
              - Path=/payment/get/**         # 断言，路径相匹配的进行路由
  ```

* 方式：

  ![image-20220718133030437](pictures/image-20220718133030437.png)





#### curl命令发送http请求

1. 不带cookie

![image-20220718140322715](pictures/image-20220718140322715.png)

2. 带cookie

   ![image-20220718140326683](pictures/image-20220718140326683.png)

3. 带请求头

   ![image-20220718140945077](pictures/image-20220718140945077.png)

4. 发`post`请求

   ![image-20220719004516278](pictures/image-20220719004516278.png)

   





## 服务配置

![image-20220718143617540](pictures/image-20220718143617540.png)

![image-20220718144011311](pictures/image-20220718144011311.png)

![image-20220718144031310](pictures/image-20220718144031310.png)





### Config×

![image-20220718185859992](pictures/image-20220718185859992.png)

![image-20220718190046927](pictures/image-20220718190046927.png)



![image-20220718190021119](pictures/image-20220718190021119.png)

> 服务配置中心更新配置时，配置客户端不需要重启，但是需要发一个`post`请求来更新配置





### Nacos









## 服务总线

![image-20220719005152826](pictures/image-20220719005152826.png)

![image-20220719011842801](pictures/image-20220719011842801.png)







### Bus

![image-20220719011927659](pictures/image-20220719011927659.png)

![image-20220719005011470](pictures/image-20220719005011470.png)





* 发送给服务中心，然后就会自动更新所有

  ![image-20220719015625647](pictures/image-20220719015625647.png)

* 通知指定结点

  ![image-20220719172156404](pictures/image-20220719172156404.png)

  > 最后`/`后面加目的地config-client：端口号



![image-20220719172513999](pictures/image-20220719172513999.png)







### Nacos







## 消息驱动

![image-20220719172955782](pictures/image-20220719172955782.png)

![image-20220719173127781](pictures/image-20220719173127781.png)





### stream

![image-20220719173618550](pictures/image-20220719173618550.png)

![image-20220719173807334](pictures/image-20220719173807334.png)

![image-20220719173844120](pictures/image-20220719173844120.png)



![image-20220720222205650](pictures/image-20220720222205650.png)

![image-20220720222341088](pictures/image-20220720222341088.png)



* 消息持久化

  把8802的分组去掉，然后让生产者8801发送消息，8802接收不到，这时候启动8803，会发现8803还是可以接收到启动之前8801发送的消息！



## Sleuth分布式请求链路跟踪



![image-20220720223927056](pictures/image-20220720223927056.png)

![image-20220720225357202](pictures/image-20220720225357202.png)

![image-20220720225423363](pictures/image-20220720225423363.png)

![image-20220720225443054](pictures/image-20220720225443054.png)

[zipkin下载地址](https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/)

我访问不了？？？