# spring-boot-starter-data-logging

[![CodeFactor](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging/badge)](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging) ![release](https://github.com/whelk-io/spring-boot-starter-data-logging/workflows/release/badge.svg)

Spring-Boot starter for reducing logging boilerplate with Spring-AOP annotations. Takes advantage of tracing and logging capabilities in Spring-Data, Spring-Cloud-Sleuth, and Lombok. 

This library is a pure AOP implementation without Java reflection, which allows for compilation on GraalVM and use on high performance frameworks such as Quarkus and Micronaut.

<br/>

## Basic Method Wrapper

Any method on a Spring managed bean can be wrapped with logging by annotating with `@Log.Around`.

````java
@Component
public class SomeBean {

  @Log.Info.Around
  public String someMethod(String param) {
    return "someReturn";
  }

}
````

```Logtalk
2020-08-22 18:36:28,811 c.e.d.SomeBean DEBUG : before [method=someMethod, args=("someParam")]

2020-08-22 18:36:28,813 c.e.d.SomeBean DEBUG : after [method=someMethod, return="someReturn"]
```

<br/>

## Change Log Level

````java
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
````

````Logtalk
2020-08-22 18:36:28,811 c.e.d.SomeBean INFO : before [method=someMethod, args=("someParam")]

2020-08-22 18:36:28,813 c.e.d.SomeBean INFO : after [method=someMethod, return="someReturn"]

2020-08-22 18:36:28,814 c.e.d.SomeBean INFO : before [method=otherMethod]

2020-08-22 18:36:28,814 c.e.d.SomeBean INFO : after [method=otherMethod, return="otherReturn"]
````

<br/>

## Additional Pointcuts

### `@Log.Before`
````java
// log before method is invoked
@Log.Before 
public String someMethod(String param) {
  return "someReturn";
}
````

````Logtalk
2020-08-22 18:45:07,631 c.e.d.SomeBean DEBUG : before [method=someMethod, args=("someParam")]
````

<br/>

### `@Log.After`

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

<br/>

### `@Log.AfterReturning`

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

<br/>

### `@Log.AfterThrowing`

````java
// log after method is invoked
// and only if exception is thrown
@Log.AfterThrowing
public String someMethod(String param) {
  throw new RuntimeException("some error");
}
````

````Logtalk
2020-08-22 18:54:56,499 c.e.d.SomeBean ERROR : thrown [method=someMethod, exception=java.lang.RuntimeException, message=some error]

{stacktrace}
````

<br/>

## Log Arguments Using Jackson

````java
@Log.Before(withArgs = 
    @Log.Args(withWriter = JacksonArgWriter.class))

@Log.AfterReturning(withReturnType = 
    @Log.ReturnType(withWriter = JacksonReturnTypeWriter.class))

public Foo someMethod(Foo foo) {
  return foo;
}
````

````Logtalk
2020-08-23 11:31:13,865 c.e.d.SomeBean DEBUG : before [method=someMethod, args=({"name":"foo","description":"foobar"})]

2020-08-23 11:31:13,870 c.e.d.SomeBean DEBUG : after [method=someMethod, return={"name":"foo","description":"foobar"}]
````
> `ArgWriter` and `ReturnTypeWriter` can be globally configured for all methods, see [Global Configuration](#global-configuration).

<br/>

## Method Configuration

### `@Log.Before` 
Log message (with method parameters) before method is invoked

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | [`@Log.Level`](#loglevel) | `@Log.Level.Debug` | Level of message when logged |
| `withArgs` | [`@Log.Args`](#logargs) | `@Log.Args` | Configuration for writing method parameters | 

<br/>

### `@Log.After`
Log message after method is invoked.

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | [`@Log.Level`](#loglevel) | `@Log.Level.Debug` | Level of message when logged |
| `withReturnException` | [`@Log.ReturnException`](#logreturnexception) | `@Log.ReturnException` | Configuration for handling uncaught exceptions |

<br/>

### `@Log.AfterReturning`
Log message with return value after method is invoked. 

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | [`@Log.Level`](#loglevel) | `@Log.Level.Debug` | Level of message when logged |
| `withReturnType` | [`@Log.ReturnType`](#logreturntype) | `@Log.ReturnType` | Configuration for writing value return from method |
| `withReturnException` | [`@Log.ReturnException`](#logreturnexception) | `@Log.ReturnException` | Configuration for handling uncaught exceptions |

<br/>

### `@Log.AfterThrowing`
Log message only after throwing an exception.

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | [`@Log.Level`](#loglevel) | `@Log.Level.Debug` | Level of message when logged |
| `withReturnException` | [`@Log.ReturnException`](#logreturnexception) | `@Log.ReturnException` | Configuration for handling uncaught exceptions |

<br/>

### `@Log.Around`
Combines other annotations to wrap a method with logging before, after, and on exception.

| Attribute   | Type | Default Value | Description | 
| ----------- | ---- | ------------- | ----------- |
| `withLevel` | [`@Log.Level`](#loglevel) | `@Log.Level.Debug` | Level of message when logged |
| `withArgs` | [`@Log.Args`](#logargs) | `@Log.Args` | Configuration for writing method parameters | 
| `withReturnType` | [`@Log.ReturnType`](#logreturntype) | `@Log.ReturnType` | Configuration for writing value return from method |
| `withReturnException` | [`@Log.ReturnException`](#logreturnexception) | `@Log.ReturnException` | Configuration for handling uncaught exceptions |

<br/>

### `@Log.Args`
Configuration for logging method parameters

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log method parameters |
| `withWriter` | [`ArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ArgWriter.java) | [`SimpleArgWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleArgWriter.java)<sup>1</sup> | Converts method parameters to `String` for logging | 

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br/>

### `@Log.ReturnType`
Configuration for logging any value returned from method.

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `enabled` | `boolean` | `true` | Whether to log return type |
| `withWriter` | [`ReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ReturnTypeWriter.java) | [`SimpleReturnTypeWriter`](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/SimpleReturnTypeWriter.java)<sup>1</sup> | Converts return type to String for logging |

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br/>

### `@Log.ReturnException`
Configuration for logging any uncaught exception thrown by method.

| Attribute | Type | Default Value | Description | 
| ----------| ---- | ------------- | ------------|
| `withStacktrace` | `boolean` | `true` | Whether to log stacktrace on exception |
| `withOverride` | `boolean` | `true` | Whether to override `withLevel` with `Log.Level.Error` on method annotation when logging exception |

> <sup>1</sup> See [Global Configuration](#global-configuration) to change value for all logging annotations.

<br/>

### `@Log.Level`
Supported log levels.

| Levels |
| --- |
| Log.Level.Trace |
| Log.Level.Debug | 
| Log.Level.Info | 
| Log.Level.Warn |
| Log.Level.Error | 
| Log.Level.Fatal | 

<br/>

## Global Configuration

By default, `SimpleArgWriter` and `SimpleReturnTypeWriter` are globally wired for method annotations. These can be changed by wiring a new `@Primary` `@Bean` for `ArgWriter` and `ReturnTypeWriter` repectively.

````java
@Configuration
public class LogConfiguration {

  @Bean
  @Primary
  public ArgWriter argWriter(JacksonArgWriter jacksonArgWriter) {
    return jacksonArgWriter;
  }

  @Bean
  @Primary
  public ReturnTypeWriter returnTypeWriter(JacksonReturnTypeWriter jacksonReturnTypeWriter) {
    return jacksonReturnTypeWriter;
  }

}
````

> Alternatively, custom writers which implement `ArgWriter` or `ReturnTypeWriter` can also be wired.

<br/>

## Auto-Logging with Spring-Data-Rest

When [`spring-boot-starter-data-rest`](https://docs.spring.io/spring-data/rest/docs/current/reference/html) is on the classpath, pointcuts are automatically applied to the default methods.

### `GET /employees`

````Logtalk
2020-08-23 13:28:26,064 tingRepository DEBUG : before [method=findAll, args=({"sort":{"sorted":false,"unsorted":true,"empty":true},"offset":0,"pageNumber":0,"pageSize":20,"paged":true,"unpaged":false})]

2020-08-23 13:28:26,073 tingRepository DEBUG : after [method=findAll, return={"content":[{"id":1,"name":"Alan Turing"}],"pageable":{"sort":{"sorted":false,"unsorted":true,"empty":true},"offset":0,"pageNumber":0,"pageSize":20,"paged":true,"unpaged":false},"last":true,"totalPages":1,"totalElements":1,"size":20,"number":0,"sort":{"sorted":false,"unsorted":true,"empty":true},"numberOfElements":1,"first":true,"empty":false}]
````

<br/>

### `GET /employees/1`

````Logtalk
2020-08-23 13:23:51,586 CrudRepository DEBUG : before [method=findById, args=(1)]

2020-08-23 13:23:51,611 CrudRepository DEBUG : after [method=findById, return={"id":1,"name":"Alan Turing"}]
````

<br/>

### `POST /employees`

````Logtalk

2020-08-23 13:22:07,634 CrudRepository DEBUG : before [method=save, args=({"name":"Alan Turing"})]

2020-08-23 13:22:07,646 CrudRepository DEBUG : after [method=save, return={"id":1,"name":"Alan Turing"}]

````

<br/>

### `PATCH /employees/1`

````Logtalk
2020-08-23 13:27:02,567 CrudRepository DEBUG : before [method=save, args=({"id":1,"name":"Alan Turing"})]

2020-08-23 13:27:02,580 CrudRepository DEBUG : after [method=save, return={"id":1,"name":"Alan Turing"}]
````


<br/>

### `PUT /employees/1`

````Logtalk
2020-08-23 13:26:10,042 CrudRepository DEBUG : before [method=save, args=({"id":1,"name":"Alan Turing"})]

2020-08-23 13:26:10,055 CrudRepository DEBUG : after [method=save, return={"id":1,"name":"Alan Turing"}]
````


<br/>

### `DELETE /employees/1`

````Logtalk
2020-08-23 13:25:28,326 CrudRepository DEBUG : before [method=deleteById, args=(1)]

2020-08-23 13:25:28,341 CrudRepository DEBUG : after [method=deleteById]
````

<br/>

## Auto-Logging with Spring-Data-JPA

When [`spring-boot-starter-data-jpa`](https://docs.spring.io/spring-data/jpa/docs/current/reference/html) is on the classpath, the inherited methods of `JpaRepository<T,ID>` are automatically applied.

````Java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
````

````Java
@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

    public Optional<Employee> findEmployeeByName(String name) {
        var exampleEmployee = new Employee();
        exampleEmployee.setName(name);

        // findOne(..) from JpaRepository automatically pointcut for logs
        return employeeRepository.findOne(Example.of(exampleEmployee));
    }

}
````

````Logtalk
2020-08-23 13:48:43.697 QueryByExampleExecutor DEBUG : before [method=findOne, args=({"probe":{"name":"Alan Turing"},"matcher":{"nullHandler":"IGNORE","defaultStringMatcher":"DEFAULT","propertySpecifiers":{"specifiers":[]},"ignoredPaths":[],"ignoreCaseEnabled":false,"matchMode":"ALL","allMatching":true,"anyMatching":false},"probeType":"com.example.demo.model.Employee"})]

2020-08-23 13:48:43.705 QueryByExampleExecutor DEBUG : after [method=findOne, return={"id":1,"name":"Alan Turing"}]
````
<br/>

## Auto-Logging with Spring-Cloud-Sleuth

When [`spring-cloud-starter-sleuth`](https://spring.io/projects/spring-cloud-sleuth) is on the classpath with [`spring-boot-starter-data-rest`](https://docs.spring.io/spring-data/rest/docs/current/reference/html), spans are automatically applied to all repository methods.

**`POST /employees`**

````Logtalk
2020-08-23 13:33:48.358 [demo,18aa9a69178dcc3f,e555838da7405451] CrudRepository DEBUG: before [method=save, args=({"name":"Alan Turing"})]

2020-08-23 13:33:48.370 [demo,18aa9a69178dcc3f,e555838da7405451] CrudRepository DEBUG : after [method=save, return={"id":1,"name":"Alan Turing"}]
````

<br/>

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

<br/> 

## Maven Integration

**`~/.m2/settings.xml`**

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

