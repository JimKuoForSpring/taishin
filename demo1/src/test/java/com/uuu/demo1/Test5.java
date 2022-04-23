package com.uuu.demo1;

import com.uuu.demo1.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RootController.class)
public class Test5 {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService service;
    @Test
    public void testServiceAndController() throws Exception {
        when(service.greet()).thenReturn("Whatever we want");
        this.mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("we want")));
    }
}
