package com.kongbig.word.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/24 15:08
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WordDto {

    /**
     * wordList
     */
    private List<String> wordList;

}
