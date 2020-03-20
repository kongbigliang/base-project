package com.kongbig.word.service;

import com.kongbig.word.common.dto.ResultDto;

import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/18 21:19
 */
public interface IWordService {

    /**
     * splitSentence
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentence(String sentence);

    /**
     * splitSentenceByUser
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentenceByUser(String sentence);

    /**
     * splitSentenceByUserAndLocal
     *
     * @param sentence
     * @return
     */
    ResultDto splitSentenceByUserAndLocal(String sentence);

    /**
     * saveUserWord
     *
     * @param wordList
     * @return
     */
    ResultDto saveUserWord(List<String> wordList);

}
