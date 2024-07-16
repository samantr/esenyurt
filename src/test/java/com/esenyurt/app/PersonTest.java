package com.esenyurt.app;

import com.esenyurt.entity.Person;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.bytebuddy.matcher.ElementMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class PersonTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void readPersonTest() throws Exception {
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/person"));
        System.out.println("sdfdf");

    }
}
