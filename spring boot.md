#一、String Boot入门  
##1、Spring Boot简介  
#####1、简化Spring应用开发的一个框架；  
#####2、整个Spring技术栈的一个大整合；  
#####3、J2EE开发的一站式解决方案；
##2、微服务  
#####微服务：架构风格（服务微化）
#####一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；
#####每一个功能元素最终都是一个可独立替换和独立升级的软件单元
#####[详细参照微服务文档](https://martinfowler.com/articles/microservices.html#MicroservicesAndSoa)  
#####环境约束：  
#####1、jdk1.8;
#####2、maven3.3.9;
#####3、IntelliJIDEA2017;
#####4、SpringBoot 1.5.9.RELEASE;
#####设置maven启动jdk版本，给maven的setting配置文件添加  
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

##3、Spring Boot项目HelloWorld  
#####功能：浏览器发送hello请求，服务器接收请求处理，响应hello world字符串；

####1.创建一个maven工程；（jar)
####2.导入依赖spring boot相关的依赖  
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
####3、编写一个主程序；启动spring boot应用，必须放在src/main/java的自己创建的目录下，才会正常启动；  
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
####4、编写相关的controller、service  
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
####5、启动项目：直接运行启动类的主程序，再使用浏览器http调用；
####6、简化部署  
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
######导入插件，在当前目录下直接使用java -jar spring_boot_01-1.0-SNAPSHOT.jar命令，运行程序；

##4、Hello World探究
####1、POM文件：父项目
	<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
他的父项目  

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-dependencies</artifactId>
		<version>1.5.9.RELEASE</version>
		<relativePath>../../spring-boot-dependencies</relativePath>
	</parent>
他来真正管理Spring Boot应用里面的所有依赖版本；  

Spring Boot的版本仲裁中心；
以后我们导入依赖默认是不需要写版本；（没有在dependences里面管理的依赖自然需要声明版本号；  
####2、启动器  
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
spring-boot-starter:spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件；  
Spring Boot将所有的功能场景都抽取出来，做成一个个的starters（启动器),只需要再项目里面引入这些starter相关场景的所有依赖就会导入进来；要用什么功能就导入什么场景的启动器。
####3、主程序类，主入口类
	@SpringBootApplication
	public class HelloSpringBootApplication {
	    public static void main(String[] args) {
	        //spring应用启动起来
	        SpringApplication.run(HelloSpringBootApplication.class, args);
	    }
	}  
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

##5、使用Spring Initializer快速创建Spring Boot项目  
IDE都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；  
向导会联网创建Spring Boot项目；  
默认生成的Spring Boot项目的特点：  
（1）主程序已经自动生成好了，只需要完成自己的逻辑开发；  
（2）resources文件夹中目录结构：  
①static：保存所有的静态资源：js css images；  
②templates：保存所有的模板页面：（spring boot默认jar包使用嵌入式的tomcat，默认不支持jsp页面）；可以使用模板引擎（freemarker、thymeleaf）；  
③application.properties:spring boot应用的配置文件；
#二、配置文件
####1、配置文件  
SpringBoot使用一个全局的配置文件，配置文件名是固定的；  
①application.properties;  
②application.yml。  
配置文件的作用：修改springboot自动配置的默认值；  
####2、获取application.properties属性  
通过@ConfigurationProperties(prefix="person")对象注解，获取以person为前缀的属性值放入当前对象的属性中。
####3、解决获取application.properties乱码问题  
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
####4、比较使用@ConfigurationProperties(prefix="person")和使用@Value()获取属性的区别  
@ConfigurationProperties:支持松散绑定（userName或user-name),@Value不支持；  
@ConfigurationProperties：不支持SpEL(#{1+2}),@Value支持；  
@ConfigurationProperties：支持JSR303数据校验，@Value不支持；
@ConfigurationProperties：支持复杂类型封装（Map,List),@Value不支持；  
如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；  
如果说，我们专门编写了一个javaBean来和配置文件进行配置，我们就直接使用@ConfigurationProperties;
####5、@PropertySource("classpath:person.properties")，通过对象注解获取指定配置文件属性值；
####6、@ImportResource(locations = {"classpath:boot.xml"})，导入spring的配置文件，让配置文件里边的内容生效，标注在主配置类上；  
####7、文件  
①对象：  

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
主配置类：  

	@SpringBootApplication
	@ImportResource(locations = {"classpath:boot.xml"})
	public class SpringBoot02Application {
	
		public static void main(String[] args) {
			SpringApplication.run(SpringBoot02Application.class, args);
		}
	
	}  
####8、使用第二种方式替换@ImportResource(locations = {"classpath:boot.xml"})生成spring的xml配置文件；  
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
####9、配置文件占位符  
①随机数  

	${random.value} ${random.int} ${random.long}   
	${random.int(10)} ${random.int[1024, 65536]} ${random.uuid}  
②没有默认值可以自定义（person.data没有值，那就用李代替）  

	person.dog.name=${person.data:李}_雪碧
