package com.prospringboot.ch03;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner, ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Value("${data.server}")
	private String dataServer;

	@Autowired
	private MyAppProperties properties;

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(DemoApplication.class);
//		app.setBanner(new CustomBanner());
		// can customize the mode of banner using SpringApplication class instance also
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
		SpringApplication.run(DemoApplication.class, args);
		// can use SpringApplicationBuilder way also to customize few things
		// can toggle logging startup info using logStartUp()
//		new SpringApplicationBuilder().logStartupInfo(false).sources(DemoApplication.class).run(args);

//		new SpringApplicationBuilder().profiles("prod", "cloud").sources(DemoApplication.class).run(args);

//		new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(DemoApplication.class).run(args);

//		new SpringApplicationBuilder(DemoApplication.class)
//				.listeners(event -> log.info("##### " + event.getClass().getCanonicalName())).run(args);
//		SpringApplication.run(DemoApplication.class, args);

		// can configure our app with a web environment
//		new SpringApplicationBuilder(DemoApplication.class).web(WebApplicationType.NONE).run(args);
	}

	@Bean
	String info() {
		return "Just a spring bean";
	}

	@Autowired
	String info;

	@Value("${server.ip}")
	private String serverIp;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("## > ApplicationRunner Implementation...");
		log.info("Accessing the Info bean: " + info);
		System.out.println(info.hashCode());// to see if it's the same object
		args.getNonOptionArgs().forEach(file -> log.info(file));
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("## > CommandLineRunner Implementation...");
		log.info("Accessing the Info bean: " + info);
		System.out.println(info.hashCode());
		for (String arg : args)
			log.info(arg);

		log.info("data server: {}", dataServer);
		log.info("server ip :: {}", serverIp);
		log.info("MyApp properties are: {}", properties);
	}

}

//@Component
//class MyComponent {
//	private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
//
//	@Autowired
//	public MyComponent(ApplicationArguments args) {
//		if (args.containsOption("Akash")) {
//			log.info("Akash was passed as arguments");
//		} else
//			log.info("Akash is not passed arguments");
//
//		log.info("Extra args: ");
//		if (!args.getNonOptionArgs().isEmpty())
//			args.getNonOptionArgs().forEach(System.out::println);
//	}
//}

//class CustomBanner implements Banner {
//
//	@Override
//	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//		out.print("\n\n\n\n THIS IS A CUSTOM BANNER \n\n\n\n");
//	}
//
//}
