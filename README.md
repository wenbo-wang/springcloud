**用于spring boot2.0集成spring cloud**


_日志记录：_

6.23 集成liquibase

6.25 集成 spring data jpa

6.25 集成 config

6.26 集成 eureka

6.30 集成 ribbon

7.6 集成 hystrix

7.13 eureka 集群

7.23 重构

7.24 zipkin  在每个服务中都添加zipkin 和 sleuth 检测效果更好

8.10 zuul swagger2 

**_踩坑日记：_**

1 config 配置要放在bootstrap.yml文件中

2 **2.0** eureka 要添加这段代码在服务端(重构的时候发现没有也可以)

```
@EnableWebSecurity
     static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
         @Override
         protected void configure(HttpSecurity http) throws Exception {
             http.csrf().disable();
         }
     }
```
3 关于 Zipkin 的服务端，在使用 Spring Boot 2.x 版本后，官方就不推荐自行   定制编译了，反而是直接提供了编译好的 jar 包来给我们使用，详情请看  
      https://github.com/openzipkin/zipkin/issues/1962
    
   zipkin使用： https://zipkin.io/pages/quickstart.html
    
    
4 zuul 集成，很坑，突然出现又突然消失的异常
    // todo 以后发现原因在补充
    
5 eureka 客户端   当使用ribbob 或 feign 访问时，服务名是 spring.application.name  而不是eureka server 上的大写名

6 config 设置端口8888 不能在mac上使用，真坑，浪费我时间

7 swagger 整合zuul 其他服务一直访问不到，原因使用包错误   

  ```
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.2.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.2.2</version>
        </dependency>
  ```
  改为：
```

        <dependency>
            <groupId>com.spring4all</groupId>
            <artifactId>swagger-spring-boot-starter</artifactId>
            <version>1.7.0.RELEASE</version>
        </dependency>

```