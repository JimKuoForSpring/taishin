package com.uuu.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class Test3 {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testNotNull() {
        assertThat(mockMvc).isNotNull();
    }
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("my first")));
    }
    @Test
    public void test404() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(status().isNotFound());
    }
}
