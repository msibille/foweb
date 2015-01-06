package demo;

import it.finsoft.FowebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FowebApplication.class)
@WebAppConfiguration
public class FowebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
