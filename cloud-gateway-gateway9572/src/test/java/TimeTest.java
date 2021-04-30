import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.ZonedDateTime;

/**
 * @author Billion
 * @create 2021-04-30 13:29
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class TimeTest {
	@Test
	public void gettime(){
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
	}
}
