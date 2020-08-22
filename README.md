# spring-boot-starter-data-logging

[![CodeFactor](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging/badge)](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging) ![release](https://github.com/whelk-io/spring-boot-starter-data-logging/workflows/release/badge.svg)

Spring-Boot starter for reducing logging boilerplate with Spring-AOP annotations. Takes advantage of tracing and logging capabilities in Spring-Data, Spring-Cloud-Sleuth, and Lombok.

## Basic Use Case

Any method on a Spring managed bean can be wrapped with logging by annotating with `Log.Around`.

````java
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Log.Around
	@Override
	public void run(String... args) throws Exception {
		// startup tasks
	}

}
````

**Console Logs**

```Logtalk
2020-08-22 15:32:16.767 com.example.demo.Application DEBUG : before [method=run, args=([])]

2020-08-22 15:32:16.772 com.example.demo.Application DEBUG : after [method=run]
```

### Method Logging

**`@Log.Before`** - Log message (with method parameters) before method is invoked

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | `@Log.Level` | `@Log.Level.Debug` | Level of message when logged |
| `withArgs` | `@Log.Args` | `@Log.Args` | Configuration for logging method parameters | 

<br> 

**`@Log.After`** - Log message after method is invoked.

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.ReturnException withReturnException() default @Log.ReturnException;

<br> 

**`@Log.AfterReturning`** - Log message with return value after method is invoked. 

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.ReturnType withReturnType() default @Log.ReturnType;

<br> 

**`@Log.AfterThrowing`** - Log message only after throwing an exception.

        Log.Level withLevel() default Log.Level.ERROR;
        Log.ReturnException withReturnException() default @Log.ReturnException;

<br> 

**`@Log.Around`** - Combines other annotations to wrap a method with logging before, after, and on exception.

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.Args withArgs() default @Log.Args;
        Log.ReturnType withReturnType() default @Log.ReturnType;
        Log.ReturnException withReturnException() default @Log.ReturnException;

<br><br>

----

### Configuration

**`@Log.Args`** - Configuration for logging method parameters

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log method parameters or not |
| `withWriter` | [`ArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ArgWriter.java) | [`SimpleArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleArgWriter.java)<sup>1</sup> | Converts method parameters to `String` for logging | 

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br><br>

**`@Log.ReturnType`**

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log return type or not |
| `withWriter` | [`ReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ReturnTypeWriter.java) | [`SimpleReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleReturnTypeWriter.java)<sup>1</sup> | Converts return type to String for logging |

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br><br>

**`@Log.ReturnException`**


        boolean withStacktrace () default true;
        boolean withOverride() default true;

<br><br>


#### Auto-Logging with Spring-Data-Rest

#### Auto-Logging with Spring-Data-JPA

#### Auto-Logging with Spring-Cloud-Sleuth

#### Global Configuration


















## Spring-Cloud-Sleuth

> Spring Cloud Sleuth provides Spring Boot auto-configuration for distributed tracing. Specifically, adds trace and span ids to the Slf4J MDC, to extract all the logs from a given trace or span in a log aggregator.

Source: [Spring Cloud Sleuth](https://spring.io/projects/spring-cloud-sleuth)

### Integration

  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
  </dependencies>

  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>

## Spring-Data-JPA

// default logging and span

## Spring-Data-MongoDB

// default logging and span

## ToString ArgWriter with Lombok

## JSON ArgWriter with Jackson

## Configure SLF4j Log Pattern

## Configure Log Message Format

// default

// how to configure custom

## Supported Versions

| Package                          | Version                      |
| -------------------------------- | ---------------------------- |
| Spring-Boot-Starter              | `2.3.1-RELEASE`              |
| Spring-Boot-Starter-AOP          | `2.3.1-RELEASE` <sup>1</sup> |
| Spring-Boot-Starter-Data-Rest    | `2.3.1-RELEASE` <sup>1</sup> |
| Spring-Boot-Starter-Data-JPA     | `2.3.1-RELEASE` <sup>1</sup> |
| Spring-Boot-Starter-Data-MongoDB | `2.3.1-RELEASE` <sup>1</sup> |
| Spring-Cloud                     | `Hoxton.SR6`                 |
| Spring-Cloud-Starter-Sleuth      | `2.2.3.RELEASE` <sup>2</sup> |
| Lombok                           | `1.18.12` <sup>1</sup>       |
| Jackson-Databind                 | `2.11.0` <sup>1</sup>        |
| Java                             | `11`                         |

<sup>1</sup> Dependency versioning inherited from `Spring-Boot-Starter`.

<sup>2</sup> Dependency versioning inherited from `Spring-Cloud`.

## Maven Integration

**~/.m2/settings.xml**

````xml
<settings>

  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>github-github-spring-boot-starter-data-logging</id>
          <url>https://maven.pkg.github.com/whelk-io/github-spring-boot-starter-data-logging</url>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github-spring-boot-starter-data-logging</id>
      <username>GITHUB_USERNAME</username>
      <password>PERSONAL_ACCESS_TOKEN</password>
    </server>
  </servers>

</settings>
````

**pom.xml**

````xml
<dependencies>
	<dependency>
        <groupId>io.whelk.spring.data.logging</groupId>
        <artifactId>spring-data-logging-starter</artifactId>
		<version>${spring-boot-starter-data-logging.version}</version>
	</dependency>
</dependencies>

<repositories>
	<repository>
		<id>github-spring-boot-starter-data-logging</id>
		<url>https://maven.pkg.github.com/whelk-io/spring-boot-starter-data-logging</url>
	</repository>
</repositories>
````

> [Additional information on authenticating with GitHub Packages](https://help.github.com/en/github/managing-packages-with-github-packages/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages)


