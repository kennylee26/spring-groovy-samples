package com.github.kennylee26.sample.jsp.controller

import com.github.kennylee26.sample.jsp.JspApplication
import org.hamcrest.beans.HasPropertyWithValue
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import javax.annotation.Resource

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * <p> UserController测试类 </p>
 * <p>Created on 27/4/15.</p>
 * @author kennylee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JspApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
@DirtiesContext
class UserControllerTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass())
    @Resource
    private WebApplicationContext wac
    private MockMvc mockMvc


    @Before
    public final void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }

    @Test
    public final void testJspByRestTemplate() {
        String username = "kenny";
        String uri = "/user/".concat(username);
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:8080" + uri, String.class)
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode())
        Assert.assertTrue("Wrong body:\n" + entity.getBody(), entity.getBody().contains(username))
        log.info(entity.getBody())
    }

    /**
     * 在此SpringBoot+JSP环境中不能利用mock获取到response，获取不能在response里添加更多断言了。
     */
    @Test
    public final void testJspByMock() {
        String username = "kenny";
        String uri = "/user/".concat(username);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri);
        ResultActions ra = mockMvc.perform(requestBuilder);
        ra.andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("user", new HasPropertyWithValue<User>("name", new IsEqual<String>(username))))
        //.andExpect(xpath("/body").exists())
                .andReturn();
        //log.info(mr.response.contentAsString)
    }
}
