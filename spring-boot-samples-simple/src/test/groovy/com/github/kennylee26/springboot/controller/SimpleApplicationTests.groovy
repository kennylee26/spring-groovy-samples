package com.github.kennylee26.springboot.controller

import com.github.kennylee26.springboot.SimpleApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = SimpleApplication)
@WebAppConfiguration
class SimpleApplicationTests {

	@Test
	void contextLoads() {
	}

}
