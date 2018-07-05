package at.bitmedia.schoolreader.version1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;


@SpringBootApplication(exclude = JmxAutoConfiguration.class)

public class Version1Application {

	public static void main(String[] args) {
		SpringApplication.run(Version1Application.class, args);
	}
}
