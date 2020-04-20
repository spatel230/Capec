package com.Stephanie.MYCAPEC;
import xpath.CapecXPath;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MycapecApplicationTests {

	@Test
	void contextLoads() {
		String x="login";
		CapecXPath.display(x);
	}

}
