**config**

添加spring cloud config 依赖

    	<dependency>
			<groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>

在Application 加 `@EnableConfigServer` 注解

在yml文件中配置：
```
spring:
  cloud:
      config:
        server:
          native:
            search-locations: classpath:/config  # 本地  config
#          git:        使用git config
#            uri: https://github.com/solocy/config.git
#            clone-on-start: true
```