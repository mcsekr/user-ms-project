package in.co.practice.ms.apigw;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "eureka.client.enabled=false"
})
class UserApiGwApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void mainMethodTest() {
		UserApiGwApplication.main(new String[]{});
	}
}
