# spring-boot-starter-data-logging

[![CodeFactor](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging/badge)](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging) ![release](https://github.com/whelk-io/spring-boot-starter-data-logging/workflows/release/badge.svg)

Spring-Boot starter for reducing logging boilerplate with Spring-AOP annotations. Takes advantage of tracing and logging capabilities in Spring-Data, Spring-Cloud-Sleuth, and Lombok.

<br>

## Basic Method Wrapper

Any method on a Spring managed bean can be wrapped with logging by annotating with `Log.Around`.

````java
@Component
public class SomeBean {

  @Log.Info.Around
  public String someMethod(String param) {
    return "someReturn";
  }

}
````

**Console Logs**

```Logtalk
2020-08-22 18:36:28,811 c.e.d.SomeBean DEBUG : before [method=someMethod, args=("someParam")]

2020-08-22 18:36:28,813 c.e.d.SomeBean DEBUG : after [method=someMethod, return="someReturn"]
```

<br>

## Change Log Level

```java
@Component
public class SomeBean {

  // change log level with @Log.{Level}.{Pointcut}
  @Log.Info.Around
  public String someMethod(String param) {
    return "foobar"
  }

  // or, on the @Log.{Pointcut} attribute
  @Log.Around(withLevel = Log.Level.Info)
  public String otherMethod() {
    return "foobar"
  }

}
```

**Console Logs**

```Logtalk
2020-08-22 18:36:28,811 c.e.d.SomeBean INFO : before [method=someMethod, args=("someParam")]

2020-08-22 18:36:28,813 c.e.d.SomeBean INFO : after [method=someMethod, return="someReturn"]

2020-08-22 18:36:28,814 c.e.d.SomeBean INFO : before [method=otherMethod]

2020-08-22 18:36:28,814 c.e.d.SomeBean INFO : after [method=otherMethod, return="otherReturn"]
```

<br>

## Additional Pointcuts

**`@Log.Before`**
````java
// log before method is invoked
@Log.Before 
public String someMethod(String param) {
  return "someReturn";
}
````

**Console Logs**

````Logtalk
2020-08-22 18:45:07,631 c.e.d.SomeBean DEBUG : before [method=someMethod, args=("someParam")]
````

<br>

**`Log.After`**

````java
// log after method has been invoked
@Log.After 
public String otherMethod() {
  return "otherReturn";
}
````

````Logtalk
2020-08-22 18:45:07,634 c.e.d.SomeBean DEBUG : after [method=otherMethod]
````

<br>

**`Log.AfterReturning`**

````java
// log after method is invoked 
// and include any value returned
@Log.AfterReturning 
public String otherMethod() {
  return "otherReturn";
}
````

````Logtalk
2020-08-22 18:48:58,171 c.e.d.SomeBean DEBUG : after [method=otherMethod, return="otherReturn"]
````

<br>

**`@Log.AfterThrowing`**

````java
// log after method is invoked
// and only if exception is thrown
@Log.AfterThrowing
public String someMethod(String param) {
  throw new RuntimeException("some error");
}
````

**Console Logs**

```Logtalk
2020-08-22 18:54:56,499 c.e.d.SomeBean ERROR : thrown [method=someMethod, exception=java.lang.RuntimeException, message=some error]

{stacktrace}
````

<br>


## Full Configurtion

### Method Logging

**`@Log.Before`** - Log message (with method parameters) before method is invoked

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | `@Log.Level` | `@Log.Level.Debug` | Level of message when logged |
| `withArgs` | `@Log.Args` | `@Log.Args` | Configuration for logging method parameters | 

<br>

**`@Log.After`** - Log message after method is invoked.

// TODO

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.ReturnException withReturnException() default @Log.ReturnException;


<br>

**`@Log.AfterReturning`** - Log message with return value after method is invoked. 

// TODO

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.ReturnType withReturnType() default @Log.ReturnType;

<br>

**`@Log.AfterThrowing`** - Log message only after throwing an exception.

// TODO

        Log.Level withLevel() default Log.Level.ERROR;
        Log.ReturnException withReturnException() default @Log.ReturnException;

<br>

**`@Log.Around`** - Combines other annotations to wrap a method with logging before, after, and on exception.

        Log.Level withLevel() default Log.Level.DEBUG;
        Log.Args withArgs() default @Log.Args;
        Log.ReturnType withReturnType() default @Log.ReturnType;
        Log.ReturnException withReturnException() default @Log.ReturnException;

<br>

### Configuration

**`@Log.Args`** - Configuration for logging method parameters

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log method parameters |
| `withWriter` | [`ArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ArgWriter.java) | [`SimpleArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleArgWriter.java)<sup>1</sup> | Converts method parameters to `String` for logging | 

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br>

**`@Log.ReturnType`**

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log return type |
| `withWriter` | [`ReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ReturnTypeWriter.java) | [`SimpleReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleReturnTypeWriter.java)<sup>1</sup> | Converts return type to String for logging |

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br>

**`@Log.ReturnException`**

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `withStacktrace` | `boolean` | `true` | Whether to log stacktrace on exception |
| `withOverride` | `boolean` | `true` | Whether to override `withLevel` with `Log.Level.Error` on method annotation when logging exception |

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br>

#### Auto-Logging with Spring-Data-Rest

// TODO

#### Auto-Logging with Spring-Data-JPA

// TODO

#### Auto-Logging with Spring-Cloud-Sleuth

// TODO

#### Global Configuration

// TODO

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

<br>

## Supported Dependencies

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

<br> 

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


