package com.kongbig.word.controller;

import com.kongbig.word.common.dto.ResultDto;
import com.kongbig.word.service.IWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/18 21:18
 */
@RestController
@RequestMapping("/word")
@Api(value = "单词", tags = "单词")
public class WordController {

    @Autowired
    private IWordService wordService;

    @GetMapping("/splitSentence")
    @ApiOperation(value = "切分单词", notes = "切分单词")
    public ResultDto splitSentence(String sentence) {
        return wordService.splitSentence(sentence);
    }

    @GetMapping("/splitSentenceByUser")
    @ApiOperation(value = "按用户自定义的字典切分单词", notes = "按用户自定义的字典切分单词")
    public ResultDto splitSentenceByUser(String sentence) {
        return wordService.splitSentenceByUser(sentence);
    }

    @GetMapping("/splitSentenceByUserAndLocal")
    @ApiOperation(value = "按用户自定义和原有的字典切分单词", notes = "按用户自定义和原有的字典切分单词")
    public ResultDto splitSentenceByUserAndLocal(String sentence) {
        return wordService.splitSentenceByUserAndLocal(sentence);
    }

    @PostMapping("/saveUserWord")
    @ApiOperation(value = "用户自定义字典", notes = "用户自定义字典")
    public ResultDto saveUserWord(List<String> wordList){
        return wordService.saveUserWord(wordList);
    }

}
