package com.kongbig.word.service;

import com.kongbig.word.common.dto.ResultDto;

import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/18 21:19
 */
public interface IWordService {

    /**
     * 切分单词
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentence(String sentence);

    /**
     * 按用户自定义的字典切分单词
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentenceByUser(String sentence);

    /**
     * 按用户自定义和原有的字典切分单词
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentenceByUserAndLocal(String sentence);

    /**
     * 用户自定义字典
     *
     * @param wordList
     * @return
     */
    ResultDto saveUserWord(List<String> wordList);

}
