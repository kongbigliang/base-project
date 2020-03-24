package com.kongbig.word.controller;

import com.kongbig.word.common.dto.ResultDto;
import com.kongbig.word.dto.WordDto;
import com.kongbig.word.service.IWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kongbig
 * @date 2020/3/18 21:18
 */
@RestController
@RequestMapping("/word")
@Api(value = "word", tags = "word")
public class WordController {

    @Autowired
    private IWordService wordService;

    @GetMapping("/splitSentence")
    @ApiOperation(value = "splitSentence", notes = "splitSentence")
    public ResultDto splitSentence(String sentence) {
        return wordService.splitSentence(sentence);
    }

    @GetMapping("/splitSentenceByUser")
    @ApiOperation(value = "splitSentenceByUser", notes = "splitSentenceByUser")
    public ResultDto splitSentenceByUser(String sentence) {
        return wordService.splitSentenceByUser(sentence);
    }

    @GetMapping("/splitSentenceByUserAndLocal")
    @ApiOperation(value = "splitSentenceByUserAndLocal", notes = "splitSentenceByUserAndLocal")
    public ResultDto splitSentenceByUserAndLocal(String sentence) {
        return wordService.splitSentenceByUserAndLocal(sentence);
    }

    @PostMapping("/saveUserWord")
    @ApiOperation(value = "saveUserWord", notes = "saveUserWord")
    public ResultDto saveUserWord(@RequestBody WordDto dto) {
        return wordService.saveUserWord(dto.getWordList());
    }

}
