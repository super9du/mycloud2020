# SpringCloud 不入门到入门

## 学习资料

- [Spring Cloud 中文文档](https://www.springcloud.cc/)
- B站 尚硅谷 Spring Cloud + Spring Cloud Alibaba 2020版
  - [视频](https://www.bilibili.com/video/BV18E411x7eT?p=137)
  - [代码](https://github.com/EiletXie/cloud2020)

## 组件导航

<table>
    <tr>
        <td>&#x274C;</td><td>不推荐使用</td>
        <td>&#x270C;</td><td>推荐使用</td>
    </tr>
</table>

| 分类                              | 名称                          | 分组                 | 推荐 | 备注                       |
| --------------------------------- | ----------------------------- | -------------------- | ---- | -------------------------- |
| [服务注册与发现](#服务注册与发现) | [Eureka](#Eureka)             | Spring Cloud         | :x:  | 停更维护                   |
|                                   | [Zookeeper](#Zookeeper)       | Spring Cloud         | :v:  |                            |
|                                   | [Consul](#Consul)             | Spring Cloud         | :v:  |                            |
|                                   | [Nacos](#Nacos)               | Spring Cloud Alibaba | :v:  |                            |
|                                   | [Dubbo](#Dubbo)               |                      |      |                            |
| [负载均衡](#负载均衡)             | [Ribbon](#Ribbon)             | Spring Cloud         | :v:  | 停更维护，但使用量仍然较多 |
|                                   | [LoadBalancer](#LoadBalancer) | Spring Cloud         | :v:  |                            |
| [服务调用](#服务调用)             | [Feign](#Feign)               | Spring Cloud         | :x:  | 过时                       |
|                                   | [OpenFeign](#OpenFeign)       | Spring Cloud         | :v:  |                            |
| [服务熔断与流控](#服务熔断与流控) | [Hystrix](#Hystrix)           | Spring Cloud         | :x:  | 使用量大，但进入停更维护   |
|                                   | [resilience4j](#resilience4j) | Spring Cloud         | :v:  | 国外使用多                 |
|                                   | [Sentinel](#Sentinel)         | Spring Cloud Alibaba | :v:  |                            |
| [链路追踪](#链路追踪)             | zipkin                        | Spring Cloud         |      |                            |
| [服务网关](#服务网关)             | Zuul                          | Spring Cloud         | :x:  | 过时                       |
|                                   | Zuul2                         | Spring Cloud         | :x:  | 难产                       |
|                                   | gateway                       | Spring Cloud         | :v:  | Spring 官方                |
| [配置中心](#配置中心)             | [config](#config)             | Spring Cloud         | :x:  |                            |
|                                   | [Nacos](#Nacos)               | Spring Cloud Alibaba | :v:  |                            |
| [消息总线](#消息总线)             | Bus                           | Spring Cloud         | :x:  |                            |
|                                   | Nacos                         | Spring Cloud Alibaba | :v:  |                            |
| [消息驱动](#消息驱动)             | Stream                        | Spring Cloud         |      |                            |
| 分布式事务                        | [Seata](#Seata)               | Spring Cloud Alibaba |      |                            |

## 注解与配置参考

### 服务注册与发现

#### Eureka

**服务端**

* 注解：`@EnableEurekaServer`

* 配置

  ```yaml
  eureka:
    instance:
      hostname: eureka7001.com
    client:
      register-with-eureka: false #false表示不向注册中心注册自己
      fetch-registry: false       #false表示自己就是注册中心
      service-url:
        # 管理中心地址
        defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
  ```

**客户端**

* 注解
  
  * `@EnableDiscoveryClient` 
  * `@EnableEurekaClient`
  
* 配置

  ```yaml
  eureka:
    instance:
      instance-id: payment8001
      prefer-ip-address: true
    client:
      service-url:
        defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
  ```

#### Zookeeper

- 注解（客户端）：`@EnableDiscoveryClient` 

- 配置

  ```
  spring:
    cloud:
      zookeeper:
        connect-string: localhost:2181
  ```


#### Consul

- 注解（客户端）：`@EnableDiscoveryClient` 

- 配置

  ```yaml
  spring:
    cloud:
      consul:
        host: localhost
        port: 8500
        discovery:
          service-name: ${spring.application.name}
  ```

### 负载均衡

#### Ribbon

> 进入维护，使用量庞大 

使用

```
@Bean
@LoadBalance
RestTemplate restTemplate() {
	return new RestTemplate();
}
```

#### LoadBalancer

> Ribbon 的替代产品，但目前使用不多

### 服务调用

#### Feign

> 不再维护

#### OpenFeign

消费端
* Main：`@EnableFeignClients`

* Service：`@FeignClient("微服务名")`，示例：

  ```java
  @FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" // 消费服务名
          , path = "payment/hystrix/" // 消费服务的URL路径
          , fallback = PaymentHystrixServiceImpl.class) // 失败回调
  ```

### 服务熔断与流控

#### Hystrix

* Main：`@EnableHystrix`, `@HystrixCommand`

* 断路器方法

  ```
  @GetMapping("payment/hystrix/timeout/{id}")
  @HystrixCommand(fallbackMethod = "timeoutFallback", commandProperties = 
  {@HystrixProperty(name = 
  	"execution.isolation.thread.timeoutInMilliseconds", value = "1500")
  })
  public String timeout(@PathVariable("id") Long id) {
  	return paymentHystrixService.timeout(id);
  }
  ```

#### resilience4j

> 待补充

### 链路追踪

zipkin（配置）

```yaml
spring:
  zipkin:
    base-url: http://localhost:9411 # zipkin 服务端地址
```

### 服务网关

> 用于请求转发、请求拦截、请求过滤

- Zuul 

- Zuul2

- gateway （router、predicate、filter）

  - 配置

    ```yaml
    spring:
      cloud:
        gateway:
          discovery:
            locator:
              enabled: true
          routes:
            - id: payment1
              uri: lb://cloud-payment-service
              predicates:
                - Path=/payment/{id}
                - Method=GET
            - id: payment2
              uri: lb://cloud-payment-service
              predicates:
                - Path=/payment
                - Method=Post
    ```

### 配置中心

#### config

**服务端**

- 注解：`@EnableConfigServer`

- 配置

  ```yaml
  spring:
    application:
      name: cloud-config-center
    cloud:
      config:
        label: master
        server:
          git:
            uri: https://github.com/super9du/SpringcloudConfig.git
            search-paths:
              # 表示在 ${git.url} 中叫 respo 的文件夹里查找配置文件
              - respo 
    rabbitmq:
      username: guest
      password: guest
      host: localhost
      port: 5672
  
  management:
    endpoints:
      web:
        exposure:
          include: 'bus-refresh' # 添加此配置允许客户端 @RefreshScope 注解实时刷新配置
  ```

**客户端**

* 注解：`@RefreshScope`（用于修改配置后实时刷新）

* 配置（bootstrap.yml）

  ```yaml
  # 表示配置文件名为：${app.name}-${profiles.active}.{yaml|yml|properties}
  spring:
    application:
      name: cloud-config-client
    cloud:
      config:
        name: user
        label: master
        profile: dev
        uri: http://localhost:3355
    rabbitmq:
      username: guest
      password: guest
      host: localhost
      port: 5672
      
  management:
    endpoints:
      web:
        exposure:
          include: "*"
  ```

### 消息总线

- Bus :x:
- Nacos :v:

### 消息驱动

* Stream

## Spring Cloud Alibaba 注解与配置参考

### Nacos

> 阿里开源。可用于服务发现、服务注册、负载均衡（内置Ribbon）、配置中心、消息总线。

官网：https://nacos.io/zh-cn/index.html

#### 服务注册与发现

- 注解（客户端）：`@EnableDiscoveryClient` 

- 配置（bootstrap.yml）

  ```yaml
  spring:
    cloud:
      nacos:
        discovery:
          server-addr: localhost:8848 # 管理中心地址
  ```

#### 配置中心

注解（客户端）：`@RefreshScope`（用于修改配置后实时刷新）

配置（bootstrap.yml）

```yaml
# 表示去 ${server-addr} 查找配置
# 使用 ${app.name}-${profiles.active}.${file-extension} 做配置文件名
spring:
  application:
    name: nacos-payment-provider
  profiles:
    active: test
  cloud:
    nacos:
      config:
        server-addr: localhost:8848
        file-extension: yaml
#        group: DEV_GROUP
#        namespace: 304fa9c6-23bb-4f24-a700-84553fc2dfa9
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

### Dubbo

待梳理

### Sentinel

> 阿里开源。用于服务熔断、服务降级、流量控制、链路追踪，与 OpenFeign 配合做服务调用。

**官网**：https://sentinelguard.io/zh-cn/

**文档**：https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D

**名词解释**

RT：平均请求时间

**使用**

* 注解：`@SentinelResource`

  ```java
  @GetMapping("byResource")
  @SentinelResource(value = "byResource", blockHandler = "exceptionHandler")
  public CommonResult<String> get() {
  	return new CommonResult<>(200, "通过 Sentinel 获取", "通过 Sentinel 获取");
  }
  
  public CommonResult<String> exceptionHandler(BlockException e) {
  	return new CommonResult<>(500, e.getMessage() + "<br>" + e.getClass().getName());
  }
  ```

  **注意**：

  `fallback` 表示业务异常处理方法；
  `blockHandler` 表示流控异常处理方法。

* 配置

  ```yaml
  spring:
    cloud:
      sentinel:
        transport:
          dashboard: localhost:8080
          port: 8719
          
  # OpenFeign 启用 Sentinel 做回调，主启动类记得加上 @EnableFeignClients
  feign:
    sentinel:
      enable: true 
  ```

**数据持久化**

[sentinel 规则持久化到nacos - 谋知 - 博客园 (cnblogs.com)](https://www.cnblogs.com/gyli20170901/p/11279576.html)

### Seata

> 阿里出品。用于实现分布式事务。

官网：http://seata.io/zh-cn/

注解：`@GlobalTransactional` 开启全局分布式事务

## 友情链接

- [知名大学开源课程收录计划（北大、清华等985、211大学课程收录计划）](https://github.com/super9du/ggs-ddu)
- [Linux 不入门到入门](https://github.com/super9du/linux-primer)
- [这才是真正的书评！](https://book.douban.com/review/12437882/)

## 学习进度

* 2020年11月28日-29日凌晨 学完   结束 seata 学习
* 2020年11月26日   第 111-136 集 结束 Sentinel 学习
* 2020年11月22日上午 第 106-110 集 结束 nacos 学习
* 2020年11月16日   第 92-105 集  nacos 学习
* 2020年11月5日    第 83-91 集   结束 spring cloud stream 学习
* 2020年11月4日    第 75-82 集   结束 config、bus 学习
* 2020年11月3日    第 73-74 集   结束 gateway 学习，开始 config 学习
* 2020年11月2日    第 63-72 集   结束 hystrix dashboard 学习，完成 Gateway Predicate 学习
* 2020年11月1日    第 58-62 集   结束 hystrix 学习
* 2020年10月27日-2020年10月31日    第 46-57 集 hystrix 学习
* 2020年10月26日   第 36-46 集   结束 Ribbon、OpenFeign 学习
* 2020年10月25日   第 31-35 集   结束 consul 学习
* 2020年10月23日   第 28-30 集   结束 zookeeper 部分学习
* 2020年10月19日-2020年10月22日  学习 zookeeper 知识（大部分时间荒废）
* 2020年10月18日   第 16-27 集   结束 Eureka 学习
* 2020年10月16日   第 1-15 集
