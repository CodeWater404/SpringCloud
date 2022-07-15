[toc]



# SpringCloud

> 学习springcloud， 参考B站尚硅谷，侵删。

详细的版本依赖[查看](https://start.spring.io/actuator/info)





## 支付模块Payment

服务提供方

> `cloud-provider-payment-8001-8002`：选用`eureka`
>
> `cloud-provider-payment-8004`：选用`zookeeper`
>
> `cloud-providerconsul-payment-8006`：选用`consul`
>
> 

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

![image-20220714201934827](pictures/image-20220714201934827.png)





## cloud-api-commons

* 抽取公共代码

别的`module`要引用只需要在`pom.xml`中引入依赖即可

```xml
<!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->
        <dependency>
            <groupId>com.codewater.com.codewater.com.codewater.springcloud</groupId>
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





### 三个服务中心异同点

![image-20220715212551463](pictures/image-20220715212551463.png)







