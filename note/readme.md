[toc]



# SpringCloud

> 学习springcloud， 参考B站尚硅谷，侵删。

详细的版本依赖[查看](https://start.spring.io/actuator/info)





## 支付模块

![image-20220702222351094](pictures/image-20220702222351094.png)

> 浏览器无法直接发送post，可以选用postman测试。
>
> 开发阶段可以采用热部署，上线就不要了





## 消费者模块

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

   ![image-20220715005943482](pictures/image-20220715005943482.png)

   

4. 支付模块也搭一个集群











