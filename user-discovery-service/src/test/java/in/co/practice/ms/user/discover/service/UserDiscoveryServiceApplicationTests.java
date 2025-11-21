package in.co.practice.ms.user.discover.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserDiscoveryServiceApplicationTests.TestApp.class, properties = "spring.cloud.compatibility-verifier.enabled=false")
class UserDiscoveryServiceApplicationTests {

	@SpringBootApplication(exclude = {
			org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration.class,
			org.springframework.cloud.configuration.CompatibilityVerifierAutoConfiguration.class
	})
	static class TestApp {
	}

	@Test
	void contextLoads() {
	}

}
