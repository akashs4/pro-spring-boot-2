package com.prospringboot.ch03;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(DemoApplication.class);
//		app.setBanner(new CustomBanner());
		// can customize the mode of banner using SpringApplication class instance also
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);

		// can use SpringApplicationBuilder way also to customize few things
		// can toggle logging startup info using logStartUp()
//		new SpringApplicationBuilder().logStartupInfo(false).sources(DemoApplication.class).run(args);

//		new SpringApplicationBuilder().profiles("prod", "cloud").sources(DemoApplication.class).run(args);

//		new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(DemoApplication.class).run(args);

		final Logger log = LoggerFactory.getLogger(DemoApplication.class);
		new SpringApplicationBuilder(DemoApplication.class)
				.listeners(event -> log.info("##### " + event.getClass().getCanonicalName())).run(args);
//		SpringApplication.run(DemoApplication.class, args);

		// can configure our app with a web environment
//		new SpringApplicationBuilder(DemoApplication.class).web(WebApplicationType.NONE).run(args);
	}

}

class CustomBanner implements Banner {

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.print("\n\n\n\n THIS IS A CUSTOM BANNER \n\n\n\n");
	}

}
