package com.kongbig.word.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/19 21:02
 */
@Configuration
public class DictionaryConfig {

    /**
     * default
     *
     * @return
     */
    @Bean(name = "dictionaryList")
    public List<String> dictionaryList() {
        return Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go");
    }

    /**
     * the user dictionary
     *
     * @return list
     */
    @Bean(name = "userDictionaryList")
    public List<String> userDictionaryList() {
        return new ArrayList<>();
    }

}
