package com.duan.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by Aduan
 * 2017/4/13 17:37.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    private static final Logger log = LoggerFactory.getLogger(GirlControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        ResultActions resu = mockMvc.perform(MockMvcRequestBuilders.get("/girls"));
        resu.andExpect(MockMvcResultMatchers.status().isOk());
        resu.andExpect(MockMvcResultMatchers.content().string("abc"));

        //log.info("content = {}",MockMvcResultMatchers.content().toString());
    }

}