package com.kongbig.word;

import com.alibaba.fastjson.JSONObject;
import com.kongbig.word.dto.WordDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

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
        log.info("splitSentence result is '{}'", content);
    }

    @Test
    public void splitSentenceByUserTest() throws Exception {
        // construct request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/word/splitSentenceByUser")
                .param("sentence", "ilikesamsungmobile");

        MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();
        log.info("splitSentenceByUser result is '{}'", content);
    }

    @Test
    public void splitSentenceByUserAndLocalTest() throws Exception {
        // construct request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/word/splitSentenceByUserAndLocal")
                .param("sentence", "ilikesamsungmobile");

        MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();
        log.info("splitSentenceByUserAndLocal result is '{}'", content);
    }

    @Test
    public void saveUserWordTest() throws Exception {
        // construct request
        List<String> wordList = Arrays.asList("hello", "world");
        WordDto dto = new WordDto(wordList);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/word/saveUserWord")
                .contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(dto));

        MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();
        log.info("splitSentenceByUserAndLocal result is '{}'", content);
    }

}
