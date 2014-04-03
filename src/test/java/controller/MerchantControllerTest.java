package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; 

@RunWith(SpringJUnit4ClassRunner.class)
//defaults to "file:src/main/webapp"
@WebAppConfiguration
//detects "WacTest-context.xml" in same package
//or static nested @Configuration class.
@ContextConfiguration
public class MerchantControllerTest {
	@Autowired
    WebApplicationContext wac; // cached.
	@Autowired
	MockServletContext servletContext;//cached
	@Autowired
	MockHttpSession session;
	@Autowired
	MockHttpServletRequest request;
	@Autowired
	MockHttpServletResponse response;
	@Autowired
	ServletWebRequest webRequest;
	
	@Autowired
    MerchantController merchantController;
    MockMvc mockMvc;
    
    @Before 
    public void setUp() throws Exception {
        // Setup Spring test in stand-alone mode
        //this.mockMvc = MockMvcBuilders.standaloneSetup(merchantController).build();
        this.mockMvc = webAppContextSetup(this.wac).build();  
    } 
	@Test
    public void accountDetail() throws Exception {
		mockMvc.perform(get("/account/detail"))
        //.andDo(print());
		.andExpect(status().isOk())
        .andExpect(content().string("John"))
        .andExpect(content().string("Jane"));
    } 
}
