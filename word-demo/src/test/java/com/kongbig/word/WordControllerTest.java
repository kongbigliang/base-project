package com.kongbig.word;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author kongbig
 * @date 2020/3/20 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void splitSentenceTest() throws Exception {
        // construct request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/word/splitSentence")
                .param("sentence", "ilikesamsungmobile");

        MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();
        log.info("result is '{}'", content);
    }

}
