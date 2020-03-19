package com.kongbig.word.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.kongbig.word.common.dto.Constants;
import com.kongbig.word.common.dto.ResultDto;
import com.kongbig.word.common.util.SplitUtil;
import com.kongbig.word.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kongbig
 * @date 2020/3/18 21:20
 */
@Service
public class WordServiceImpl implements IWordService {

    private static final String LOCAL = "local_";
    private static final String USER = "user_";
    private static final String LOCAL_USER = "local_user_";

    @Autowired
    @Qualifier("dictionaryList")
    private List<String> dictionaryList;
    @Autowired
    @Qualifier("userDictionaryList")
    private List<String> userDictionaryList;

    @Override
    public ResultDto splitSentence(String sentence) {
        List<String> list = SplitUtil.splitSentence(sentence, dictionaryList);
        if (CollUtil.isEmpty(list)) {
            return ResultDto.fail("has not result");
        }
        return ResultDto.ok(list);
    }

    @Override
    public ResultDto splitSentenceByUser(String sentence) {
        List<String> list = SplitUtil.splitSentence(sentence, userDictionaryList);
        if (CollUtil.isEmpty(list)) {
            return ResultDto.fail("has not result");
        }
        return ResultDto.ok(list);
    }

    @Override
    public ResultDto splitSentenceByUserAndLocal(String sentence) {
        List<String> list = new ArrayList<>();
        list.addAll(dictionaryList);
        list.addAll(userDictionaryList);
        list.stream().distinct().collect(Collectors.toList());
        List<String> results = SplitUtil.splitSentence(sentence, list);
        if (CollUtil.isEmpty(results)) {
            return ResultDto.fail("has not result");
        }
        return ResultDto.ok(results);
    }

    @Override
    public ResultDto saveUserWord(List<String> wordList) {
        userDictionaryList.addAll(wordList);
        userDictionaryList = userDictionaryList.stream().filter((s) -> !s.equalsIgnoreCase("")).distinct().collect(Collectors.toList());
        return ResultDto.ok(null);
    }

}
