# spring-boot-starter-data-logging

[![CodeFactor](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging/badge)](https://www.codefactor.io/repository/github/whelk-io/spring-boot-starter-data-logging) ![release](https://github.com/whelk-io/spring-boot-starter-data-logging/workflows/release/badge.svg)

Spring-Boot starter for reducing logging boilerplate with Spring-AOP annotations. Takes advantage of tracing and logging capabilities in Spring-Data, Spring-Cloud-Sleuth, and Lombok.

## Basic Example

Given a <code>[Spring-Data-JPA](https://spring.io/projects/spring-data-jpa)</code> entity: 

````java
@Data
@Entity
public class Foo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Version
    private int version;

}
````

And a <code>[Spring-Data-REST](https://spring.io/projects/spring-data-rest)</code> <code>[RepositoryRestResource](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#repository-resources)</code>:

````java
@RepositoryRestResource
public interface FooRepository extends JpaRepository<Foo, Long> { }
````

And a <code>[Spring-Data-REST](https://spring.io/projects/spring-data-rest)</code> <code>[RepositoryEventHandler](https://docs.spring.io/spring-data/rest/docs/2.0.0.M1/reference/html/events-chapter.html)</code>:
````java
@Slf4j
@Component
@RepositoryEventHandler
public class FooEventHandler {

    @HandleAfterCreate
    public void handleCreate(final Foo foo) {
        log.info("foo created, do something");
    }

}
````

Observe logs generated
````log
2020-07-04 12:17:19.583  INFO [foo,6aaf12d29bafd856,6aaf12d29bafd856,true] 21978 --- [nio-8080-exec-2] com.example.demo.event.FooEventHandler   : foo created, do something
````

At the method `handleCreate(..)`, add annotation <code>[@Log.Around](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/aop/Log.java)</code> from <code>[Spring-Boot-Starter-Data-Logging](https://github.com/whelk-io/spring-boot-starter-data-logging)</code>:

````java
@Slf4j
@Component
@RepositoryEventHandler
public class FooEventHandler {

    @Log.Around
    @HandleAfterCreate
    public void handleCreate(final Foo foo) {
        log.info("foo created, do something");
    }

}
````

Observe logs generated
````log
2020-07-04 12:20:37.652 DEBUG [foo,99b86b1544f68f1a,99b86b1544f68f1a,true] 21978 --- [nio-8080-exec-5] com.example.demo.event.FooEventHandler   : before [method=handleCreate, args=(Foo(id=2, name=fubar, version=0))]

2020-07-04 12:20:37.653  INFO [foo,99b86b1544f68f1a,99b86b1544f68f1a,true] 21978 --- [nio-8080-exec-5] com.example.demo.event.FooEventHandler   : foo created, do something

2020-07-04 12:20:37.653 DEBUG [foo,99b86b1544f68f1a,99b86b1544f68f1a,true] 21978 --- [nio-8080-exec-5] com.example.demo.event.FooEventHandler   : after [method=handleCreate]
````

## Logging Method Annotations

<code>[@Log.Around](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/aop/Log.java)</code> - Log messages before and after annotated method executes.
 - `@Log.Around(withLevel=LogLevel.DEBUG)` - <code>[LogLevel](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html)</code> to write log messages, defaults to <code>[LogLevel.DEBUG](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html#DEBUG)</code>
 - `@Log.Around(withArgs=true)` - Log method parameters using wired [ArgWriter](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ArgWriter.java). 

<code>[@Log.Before](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/aop/Log.java)</code> - Log messages only before annotated method executes.
  - `@Log.Before(withLevel=LogLevel.DEBUG)` - <code>[LogLevel](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html)</code> to write log messages, defaults to <code>[LogLevel.DEBUG](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html#DEBUG)</code>
  - `@Log.Before(withArgs=true)` - Log method parameters using wired [ArgWriter](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/writer/ArgWriter.java). 

<code>[@Log.After](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/aop/Log.java)</code> - Log messsages only after annotated method executes, regardless if returns `void`, any `Object`, or any `Exception`.
  - `@Log.After(withLevel=LogLevel.DEBUG)` - <code>[LogLevel](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html)</code> to write log messages, defaults to <code>[LogLevel.DEBUG](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html#DEBUG)</code>

<code>[@Log.AfterReturning](https://github.com/whelk-io/spring-boot-starter-data-logging/blob/master/src/main/java/io/whelk/spring/data/logging/aop/Log.java)</code> - Log messages only after annotated method executes and returns non-`void` value.
  - `@Log.AfterReturning(withLevel=LogLevel.DEBUG)` - <code>[LogLevel](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html)</code> to write log messages, defaults to <code>[LogLevel.DEBUG](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/logging/LogLevel.html#DEBUG)</code>


// TODO
// adhoc
// auto for repo
  /// mongo, jpa variants

// TODO

## Configure SLF4j Log Format

// how to configure log pattern

## Configure Log Message Format

// default

// how to configure custom

## Configure Argument Writer

### Use Basic Writer

// Lombok.toString Exclude/Include

### Use Jackson Writer

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

More information on authenticating with GitHub packages: https://help.github.com/en/github/managing-packages-with-github-packages/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages


