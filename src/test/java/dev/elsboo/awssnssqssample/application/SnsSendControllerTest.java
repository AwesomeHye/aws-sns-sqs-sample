package dev.elsboo.awssnssqssample.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SnsSendControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void send() throws Exception {
        mockMvc.perform(get("/sns/send").param("message", "i am groot"))
                .andExpect(status().isOk())
                .andDo(print())
                ;
    }
}