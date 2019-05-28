# 一、String Boot入门  

#### 1、Spring Boot简介  

1、简化Spring应用开发的一个框架；

2、整个Spring技术栈的一个大整合；  

3、J2EE开发的一站式解决方案；

#### 2、微服务  

微服务：架构风格（服务微化）

一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；

每一个功能元素最终都是一个可独立替换和独立升级的软件单元

[详细参照微服务文档](https://martinfowler.com/articles/microservices.html#MicroservicesAndSoa)  

环境约束：  

1、jdk1.8;

2、maven3.3.9;

3、IntelliJIDEA2017;

4、SpringBoot 1.5.9.RELEASE;

设置maven启动jdk版本，给maven的setting配置文件添加  

```
java
<profiles> 
	<profile> 
		<id>jdk1.8</id>
		<activation>
			<activeByDefault>true</activeByDefault>
		</activation>
		<properties>
			<maven.compiler.source>1.8</maven.compiler.source>
			<maven.compiler.target>1.8</maven.compiler.target>
			<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
		</properties>
	</profile>
</profiles>  
```

#### 3、Spring Boot项目HelloWorld  

功能：浏览器发送hello请求，服务器接收请求处理，响应hello world字符串；

1.创建一个maven工程；（jar)

2.导入依赖spring boot相关的依赖  

```java
<parent>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-parent</artifactId>
   <version>1.5.9.RELEASE</version>
   <relativePath/> <!-- lookup parent from repository -->
</parent>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>  
```
3、编写一个主程序；启动spring boot应用，必须放在src/main/java的自己创建的目录下，才会正常启动；  

```java
    /**
      * Description: 标注主程序类，说明是一个SpringBoot类
      *
      * @Date:2019/4/13
      * @Author:lc
     */
    @SpringBootApplication
    public class HelloSpringBootApplication {
        public static void main(String[] args) {
            //spring应用启动起来
            SpringApplication.run(HelloSpringBootApplication.class, args);
        }
    }
```

4、编写相关的controller、service  

```java
	/**
	  * Description: 方法输出文本"hello Spring Boot"
      *
      * @Date:2019/4/13
      * @Author:lc
    */
    @Controller
    @RequestMapping("/api")
    public class HelloSpringBoot {
        @ResponseBody
        @RequestMapping("/hello")
        public String hello() {
            return "hello Spring Boot";
        }
    }
```

5、启动项目：直接运行启动类的主程序，再使用浏览器http调用；

6、简化部署  

```java
<!--插件作用：可以将应用打包成一个可执行的jar包-->

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <executable>true</executable>
                    <fork>false</fork>
                </configuration>
            </plugin>
        </plugins>
    </build>  
```

导入插件，在当前目录下直接使用java -jar spring_boot_01-1.0-SNAPSHOT.jar命令，运行程序；

#### 4、Hello World探究

1、POM文件：父项目

```java
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```


它的父项目  

```java
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-dependencies</artifactId>
	<version>1.5.9.RELEASE</version>
	<relativePath>../../spring-boot-dependencies</relativePath>
</parent>
```
它来真正管理Spring Boot应用里面的所有依赖版本；  

Spring Boot的版本仲裁中心；
以后我们导入依赖默认是不需要写版本；（没有在dependences里面管理的依赖自然需要声明版本号；  

2、启动器  

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter:spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件；  
Spring Boot将所有的功能场景都抽取出来，做成一个个的starters（启动器),只需要再项目里面引入这些starter相关场景的所有依赖就会导入进来；要用什么功能就导入什么场景的启动器。

3、主程序类，主入口类

```java
@SpringBootApplication
public class HelloSpringBootApplication {
	public static void main(String[] args) {
	    //spring应用启动起来
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}
} 
```


 @SpringBootApplication：SpringBoot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；  

	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Inherited
	@SpringBootConfiguration
	@EnableAutoConfiguration
	@ComponentScan(
	    excludeFilters = {@Filter(
	    type = FilterType.CUSTOM,
	    classes = {TypeExcludeFilter.class}
	), @Filter(
	    type = FilterType.CUSTOM,
	    classes = {AutoConfigurationExcludeFilter.class}
	)}
	)  
@SpringBootConfiguration：SpringBoot配置类；  
标注在某个类上，表示这是一个SpringBoot的配置类；  
父配置：@Configuration：配置类上标注这个注解；  
配置类====配置文件；配置类也是容器的一个组件；  
@EnableAutoConfiguration：开启自动配置功能；  
父配置：@AutoConfigurationPackage：将主配置类（@SpringBootConfiguration注解标注的类）的所在包及所属子包里面的所有组件扫描到spring容器；

4、使用Spring Initializer快速创建Spring Boot项目  

IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；  
向导会联网创建Spring Boot项目；  
默认生成的Spring Boot项目的特点：  
（1）主程序已经自动生成好了，只需要完成自己的逻辑开发；  
（2）resources文件夹中目录结构：  
①static：保存所有的静态资源：js css images；  
②templates：保存所有的模板页面：可以使用模板引擎（freemarker、thymeleaf）；  
③application.properties:spring boot应用的配置文件；

# 二、配置文件

#### 1、配置文件  

SpringBoot使用一个全局的配置文件，配置文件名是固定的；  
①application.properties;  
②application.yml。  
配置文件的作用：修改springboot自动配置的默认值；  

#### 2、获取application.properties属性  

通过@ConfigurationProperties(prefix="person")对象注解，获取以person为前缀的属性值放入当前对象的属性中。

#### 3、解决获取application.properties乱码问题  

①在配置文件中加入配置  

	server.tomcat.uri-encoding=UTF-8
	spring.http.encoding.charset=UTF-8
	spring.http.encoding.enabled=true
	spring.http.encoding.force=true
	spring.messages.encoding=UTF-8
②还是乱码，修改idea配置  
设置 File Encodings的Transparent native-to-ascii conversion为true，  
具体步骤如下：依次点击
File -> Settings -> Editor -> File Encodings
将Properties Files (*.properties)下的Default encoding for properties files设置为UTF-8，将Transparent native-to-ascii conversion前的勾选上。  

#### 4、比较使用@ConfigurationProperties(prefix="person")和使用@Value()获取属性的区别  

@ConfigurationProperties:支持松散绑定（userName或user-name),@Value不支持；  
@ConfigurationProperties：不支持SpEL(#{1+2}),@Value支持；  
@ConfigurationProperties：支持JSR303数据校验，@Value不支持；
@ConfigurationProperties：支持复杂类型封装（Map,List),@Value不支持；  
如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；  
如果说，我们专门编写了一个javaBean来和配置文件进行配置，我们就直接使用@ConfigurationProperties;

#### 5、@PropertySource("classpath:person.properties")，通过对象注解获取指定配置文件属性值；

#### 6、@ImportResource(locations = {"classpath:boot.xml"})，导入spring的配置文件，让配置文件里边的内容生效，标注在主配置类上； 
#### 7、文件  

①对象：  

```java
@Component
@PropertySource("classpath:person.properties")
//@ConfigurationProperties(prefix="person")
//@Validated
public class Person {
    //@Email
    //@Value("${person.name}")
    private String name;
    //@Value("#{12+5}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    //@Value("2019/4/14")
    private Date birthday;
    private Map<String, Object> maps;
    private List<Object> list;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}  
```
主配置类：  

```java
@SpringBootApplication
@ImportResource(locations = {"classpath:boot.xml"})
public class SpringBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Application.class, args);
	}

}  
```
#### 8、使用第二种方式替换@ImportResource(locations = {"classpath:boot.xml"})生成spring的xml配置文件；  

	    /**
		 * Description:指明当前类是一个配置类；就是替代spring的xml配置文件
		 *
		 * @Date:2019/4/14
		 * @Author:lc
		 */
		@Configuration
		public class SpringBootConfig {
	        // 将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
	        @Bean
	        public BootService bootService() {
	            return new BootService();
	        }
	
	    }
#### 9、配置文件占位符  

①随机数  

```java
${random.value} ${random.int} ${random.long}   
${random.int(10)} ${random.int[1024, 65536]} ${random.uuid}  
```
②没有默认值可以自定义（person.data没有值，那就用李代替）  

```java
person.dog.name=${person.data:李}_雪碧  
```
#### 10、spring.profiles.active=dev，用来激活启动版本，使用dev版本启动spring boot  

#### 11、server.servlet.context-path=/boot，URL添加固定配置，访问如：http://localhost:8022/boot/api/study  

#### 12、debug=true, 查看所有的可用配置文件和不可用配置文件

# 三、日志  

springboot的日志为log4j2(作用于接口）+logback（作用于实现类）。  
日志级别，由低到高trace<debug<info<warn<error。  

application.properties配置文件中设置：  
① logging.level.com.lc = trace;自定义设置日志级别，默认为info；  
② logging.file=logging.xml;将日志打印在项目根目录下，生成logging.xml文件中；  
③ logging.path=/spring/logging;将日志打印在项目盘符下/spring/logging路径下生成logger.log中；  

# 四、WEB开发  

#### 1、静态文件存放路径 

 ①classpath：/resources;  
②classpath：/static;  
③classpath：/public;  
自动从三个资源文件中寻找css、js等配置文件资源。  

#### 2、HTML模板引擎存放路径

classpath：/templates，必须引入spring-boot-starter-thymeleaf的jar包，默认查找index.html

#### 3、使用jsp文件

创建存放jsp的路径WEB-INF/jsp,需要创建WEB-INF/web.xml, 

![](assets/1558150256474.png)
需要引入spring-boot-starter-tomcat和tomcat-jasper的jar包，  
application.properties需要配置前后缀：spring.mvc.view.prefix=/WEB-INF/jsp/和spring.mvc.view.suffix=.jsp  

使用Apache的tomcat启动项目：

![](assets/1558150475732.png)

#### 4、pom.xml依赖jar包
	    <!-- 依赖父项目，版本控制 --> 
	    <parent>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-parent</artifactId>
	        <version>1.5.13.RELEASE</version>
	        <relativePath/> <!-- lookup parent from repository -->
	    </parent>
	
	    <!-- 自定义配置版本 -->
	    <properties>
	        <java.version>1.8</java.version>
	    </properties>
	
	    <dependencies>
		<!-- web项目开发，使用自定义日志文件 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
	    <!-- 测试jar -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
	    <!-- log4j2日志 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
	
		<!-- 使用thymeleaf模板引擎 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
	
		<!-- 连接mybatis -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.3.2</version>
		</dependency>
	
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
	
		<!-- 使用alibaba数据源druid -->
		<dependency>
	        <groupId>com.alibaba</groupId>
	        <artifactId>druid</artifactId>
	        <version>1.1.9</version>
		</dependency>
	</dependencies>
	
	<!-- 定义一个可执行jar文件 -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
#### 5、application.properties配置文件  
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot?characterEncoding=utf8
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
	#初始连接数
	spring.datasource.druid.initial-size=5
	#最大连接数
	spring.datasource.druid.max-active=20
	#最小空闲
	spring.datasource.druid.min-idle=5
	#最大等待时间
	spring.datasource.druid.max-wait=6000
	#每60秒运行一次空闲连接回收器
	spring.datasource.druid.time-between-eviction-runs-millis=60000
	#池中的连接空闲5分钟后被回收
	spring.datasource.druid.min-evictable-idle-time-millis=300000
	#验证使用的SQL语句
	spring.datasource.druid.validation-query=SELECT 1 FROM DUAL
	#指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除.
	spring.datasource.druid.test-while-idle=true
	#借出连接时不要测试，否则很影响性能
	spring.datasource.druid.test-on-borrow=false
	#生产环境归还连接时不要测试
	spring.datasource.druid.test-on-return=false
	#是否自动回收超时连接
	spring.datasource.druid.remove-abandoned=true
	#超时时间(以秒数为单位)
	spring.datasource.druid.remove-abandoned-timeout=10
	#是否在自动回收超时连接的时候打印连接的超时错误
	spring.datasource.druid.log-abandoned=true
	# 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
	spring.datasource.druid.filters=stat,wall,log4j
	# 是否缓存preparedStatement，也就是PSCache  官方建议MySQL下建议关闭   个人建议如果想用SQL防火墙 建议打开
	spring.datasource.druid.pool-prepared-statements=true
	# 最大的连接池就绪等待连接数量
	spring.datasource.druid.max-pool-prepared-statement-per-connection-size=20
	
	#mybatis配置文件路径
	mybatis.config-location=classpath:mybatis/mybatis-config.xml
	#mybatis映射文件xml存放路径
	mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
#### 6、mybatis-config.xml配置文件
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE configuration
	        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	        "http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
	    <settings>
			<!--设置驼峰命名格式，将表中user_name转化为类中的userName -->
	        <setting name="mapUnderscoreToCamelCase" value="true"/>
	    </settings>
	</configuration>
第二种方式mybatis自定配置MyMybatisConfig.java  

	@Configuration
	public class MyMybatisConfig {
	    @Bean
	    public ConfigurationCustomizer configurationCustomizer() {
	        return new ConfigurationCustomizer() {
	            @Override
	            public void customize(org.apache.ibatis.session.Configuration configuration) 			 {
	                configuration.setMapUnderscoreToCamelCase(true);
	            }
	        };
	    }
	}
#### 7、druid数据源配置文件MyDruidConfig.java  
	@Configuration
	public class MyDruidConfig {
	
	    @ConfigurationProperties(prefix = "spring.datasource")
	    @Bean
	    public DataSource druid() {
	        return new DruidDataSource();
	    }
	
		// 使用servlet功能
	    @Bean
	    public ServletRegistrationBean statViewServlet() {
	        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("loginUsername", "admin");
	        map.put("loginPassword", "123");
	        bean.setInitParameters(map);
	        return bean;
	    }
	
		// 使用过滤器功能
	    @Bean
	    public FilterRegistrationBean filterRegistrationBean() {
	        FilterRegistrationBean bean = new FilterRegistrationBean();
	        bean.setFilter(new WebStatFilter());
	        Map<String, String> map = new HashMap<>();
	        map.put("exclusions", "*.js, *.css, /druid/*");
	        bean.setInitParameters(map);
	        bean.setUrlPatterns(Arrays.asList("/*"));
	        return bean;
	    }
	
	}
#### 8、自定义登录拦截器MyLoginHandlerInterceptor.java  
	public class MyLoginHandlerInterceptor implements HandlerInterceptor {
	
	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
	        String loginUsername = (String)request.getSession().getAttribute("loginUser");
	        if(!StringUtils.isEmpty(loginUsername)) {
	            return true;
	        }
	        request.setAttribute("msg", "没有权限请先登录");
	        request.getRequestDispatcher("/index.html").forward(request, response);
	        return false;
	    }
	
	    @Override
	    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	
	    }
	
	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	
	    }
	}
#### 9、拦截控制转发请求对应资源

	@Configuration
	public class MyMvcConfig implements WebMvcConfigurer{
		// 转发强求到到指定页面中
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("login");
	        registry.addViewController("/index.html").setViewName("login");
	        registry.addViewController("/login.html").setViewName("login");
	    }
	    
	    // 使自己定义的拦截器生效
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new MyLoginHandlerInterceptor()).addPathPatterns("/**")
	            .excludePathPatterns("/index.html", "/", "/user/login");
	    }
	
	}

## 五、与定时任务Quartz和定时器Core结合使用 

#### 1、pom.xml引入Quartz依赖 

```java
		<dependency>
			<groupId>org.quartz-scheduler</groupId>
			<artifactId>quartz</artifactId>
			<version>2.3.1</version>
		</dependency>

		<dependency>
			<groupId>org.quartz-scheduler</groupId>
			<artifactId>quartz-jobs</artifactId>
			<version>2.3.1</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>4.3.13.RELEASE</version>
		</dependency>
```

#### 2、添加quartz.properties配置文件 

```java
org.quartz.scheduler.instanceName = cloudScheduler 
org.quartz.scheduler.instanceId = AUTO  

org.quartz.threadPool.class = org.quartz.simpl.SimpleThreadPool 
org.quartz.threadPool.threadCount = 10 
org.quartz.threadPool.threadPriority = 5 
org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread = true 

org.quartz.jobStore.misfireThreshold = 60000


#org.quartz.jobStore.class属性为 JobStoreTX，将任务持久化到数据中。   
#集群中节点依赖于数据库来传播 Scheduler 实例的状态，你只能在使用 JDBC JobStore 时应用 Quartz 集群。   
org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreTX 
org.quartz.jobStore.driverDelegateClass=org.quartz.impl.jdbcjobstore.StdJDBCDelegate 
org.quartz.jobStore.tablePrefix = QRTZ_
org.quartz.jobStore.maxMisfiresToHandleAtATime=10 
#org.quartz.jobStore.isClustered 属性为 true，实例要它参与到一个集群当中。   
org.quartz.jobStore.isClustered = false  
org.quartz.jobStore.clusterCheckinInterval = 3600000
```

#### 3、生成quartz表

```
QRTZ_JOB_DETAILS，
QRTZ_TRIGGERS，
QRTZ_SIMPLE_TRIGGERS，
QRTZ_CRON_TRIGGERS，
QRTZ_SIMPROP_TRIGGERS，
QRTZ_BLOB_TRIGGERS，
QRTZ_CALENDARS，
QRTZ_PAUSED_TRIGGER_GRPS，
QRTZ_FIRED_TRIGGERS，
QRTZ_SCHEDULER_STATE，
QRTZ_LOCKS
```

#### 4、配置jobFactory，使用@Autowired注解注入 

```java
@Component("jobFactory")
public class AutoWiredSpringBeanToJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {
    private transient AutowireCapableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception 	 {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
```

#### 5、引入quartz.properties文件，配置数据源

```java
@Configuration
public class QuartzConfig {
    // 配置文件路径
    private static final String QUARTZ_CONFIG = "/quartz.properties";

    // 查询系统中配置好的数据源添加到配置
    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;
    @Autowired
    private JobFactory jobFactory;

    /**
     * @return
     * @throws IOException
     */
    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        //从quartz.properties文件中读取Quartz配置属性
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_CONFIG));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();

        //创建SchedulerFactoryBean
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(propertiesFactoryBean.getObject());
        // 使用应用的dataSource替换quartz的dataSource
        factory.setDataSource(dataSource);
        factory.setJobFactory(jobFactory);

        factory.setOverwriteExistingJobs(true);
        // 设置自行启动
        factory.setAutoStartup(true);

        return factory;
    }

}
```

#### 6、得到spring管理的类名称工具SpringUtil.java

```java
@Component
public class SpringUtil implements ApplicationContextAware {
   /**
    * 上下文对象实例
    */
   public static ApplicationContext applicationContext;

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      if(applicationContext!=null&&this.applicationContext==null){
         this.applicationContext = applicationContext;
      }
   }

   /**
    * 获取applicationContext
    * 
    * @return
    */
   public static ApplicationContext getApplicationContext() {
      return applicationContext;
   }

   /**
    * 通过name获取 Bean.
    * 
    * @param name
    * @return
    */
   public static Object getBean(String name) {
      return getApplicationContext().getBean(name);
   }

   /**
    * 通过class获取Bean.
    * 
    * @param clazz
    * @param <T>
    * @return
    */
   public static <T> T getBean(Class<T> clazz) {
      return getApplicationContext().getBean(clazz);
   }

   /**
    * 通过name,以及Clazz返回指定的Bean
    * 
    * @param name
    * @param clazz
    * @param <T>
    * @return
    */
   public static <T> T getBean(String name, Class<T> clazz) {
      return getApplicationContext().getBean(name, clazz);
   }
}
```

#### 7、生成定时任务JobUtil.java

```java
public class JobUtil {

    public static final Logger logger = LoggerFactory.getLogger(JobUtil.class);

    private static JobUtil jobUtil = new JobUtil();

    public static Scheduler scheduler = null;

    private JobUtil() {
        logger.info("SchedulerMain is created");
    }

    // 使用单例代替spring管理注入
    public static JobUtil getInstance() {
        if (scheduler == null){
            synchronized (JobUtil.class){
                if (scheduler == null){
                    scheduler = SpringUtil.getBean(Scheduler.class);
                }
            }
        }
        return jobUtil;
    }

    public void addSchedulerJob(String quartzName,String quartzGroup, 
                                String cronExpression) throws Exception {

        JobDetail jobDetail = JobBuilder.newJob(EmployerJob.class)
            .withIdentity(quartzName, quartzGroup)
            .storeDurably(false).build();

        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail)
            .withIdentity(quartzName, quartzGroup)
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    // 调用任务用到反射，实体类必须序列化
    public void addSchedulerTask(Task task, TaskPloy taskPloy) throws Exception{

        String name = task.getName();
        String group = task.getTaskGroup();

        // 先停止删除定时任务
        scheduler.unscheduleJob(TriggerKey.triggerKey(name, group));
        scheduler.deleteJob(JobKey.jobKey(name, group));

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("task", task);
        jobDataMap.put("taskPloy", taskPloy);

        JobDetail jobDetail = JobBuilder.newJob(TaskJob.class)
            	.withIdentity(name, group).storeDurably(false)
                .requestRecovery().setJobData(jobDataMap).build();

        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail)
               .withIdentity(name, group)
               .withSchedule(CronScheduleBuilder.cronSchedule(task.getConfig())).build();

        // 再开启定时任务
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public void taskStop(Task task) throws SchedulerException {
        String name = task.getName();
        String group = task.getTaskGroup();
        scheduler.unscheduleJob(TriggerKey.triggerKey(name, group));
    }

}
```

用到spring反射机制，实体类必须序列化。

## 六、springboot与docker结合使用

#### 1、环境描述

①虚拟机网络适配器为桥接模式，IP和主机为同一网段，互相可以ping通，ping操作时主机需要关闭防火墙；

②linux的镜像centOS必须是64位，查询内核版本(uname -r)且内核版本需要是2.6.32版本及以上；

#### 2、使用docker

①安装第三方库：yum install https://get.docker.com/rpm/1.7.1/centos-6/RPMS/x86_64/docker-engine-1.7.1-1.el6.x86_64.rpm

②安装docker-io：yum install docker-io；

出现错误No package docker-io available，以下两种解决方法：

```java
yum install epel-release
yum install docker-io
```

或

```JAVA
yum upgrade device-mapper-lib
yum install docker-io
```

启动docker：service docker start

测试：查看docker版本：docker -v，查看mysql镜像：docker search mysql；

③镜像操作，拉取存放容器中

![](assets/1558931471660.png)

④启动容器

​      	![image](assets/1558932901450.png)

⑤启动mysql数据库，生成编码格式

docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql -d mysql:5.6.42 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

## 七、springboot使用缓存  

#### 1、spring缓存抽象  

**①**pom.xml导入依赖    

```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

**②**在程序入口主函数中添加注解@EnableCaching，使用spring抽象缓存；

**③**需要被缓存的方法上添加注解@Cacheable(cacheNames = "emp")；

原理：先查询缓存是否有数据，有就直接返回，没有就查询数据库，返回的数据存入缓存，缓存的key为方法参数，没有参数spring自动生成，一个参数情况就为key，多个参数组合使用为key；

Cacheable其他属性：

**key**：如key = "#root.methodName+'['+#id+']'"，自定义key，#root.methodName获取方法名，#id获取参数；

**condition**：如condition = "#id > 1 and #root.getMethodName() eq 'getDepartmentById'"，自定义条件id>1并且方法名为getDepartmentById时进行缓存；

**unless**：如unless = "#id == 2"，自定义id=2时不进行缓存；

**④**修改方法上添加@CachePut(value = "emp", key = "#result.id") 修改方法并更新缓存，存入缓存时的key为对象id时，更新时，应该也要从对象中取出id去更新缓存；

**⑤**删除方法上添加@CacheEvict(value = "emp", key = "#id")删除方法执行之后并删除以id值为key的缓存，可以使用allEntries = true代替key，删除所有的缓存；

#### 2、使用redis缓存