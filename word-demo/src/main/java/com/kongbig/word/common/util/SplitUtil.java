package com.kongbig.word.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongbig
 * @date 2020/3/19 20:22
 */
public class SplitUtil {

    public static List<String> splitSentence(String sentence, List<String> dictionaryList) {
        return getBreakResult(sentence, dictionaryList, 0);
    }

    /**
     * break input search form local dictionary or user dictionary or those
     *
     * @param s
     * @param wordDict
     * @param offset
     * @return
     */
    private static List<String> getBreakResult(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> resultList = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = getBreakResult(s, wordDict, offset + word.length());
                for (String str : next) {
                    resultList.add((word + " " + str).trim());
                }
            }
        }
        return resultList;
    }

}
