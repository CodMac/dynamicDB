package zqit.dynamicDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import zqit.dynamicDB.pulgins.dynamicDB.DynamicDataSourceRegister;

@EnableAutoConfiguration
@ServletComponentScan // 扫描Filter等servlet容器
@ComponentScan
@SpringBootApplication
@Import({ DynamicDataSourceRegister.class }) // 注册动态多数据源
public class App extends SpringBootServletInitializer // 需要打包为war时，继承SpringBootServletInitializer，同时重写configure方法
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}