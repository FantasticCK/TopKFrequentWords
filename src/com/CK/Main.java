package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(words, k).toString());
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        List<String> res = new ArrayList<>();
        int cur = 0;
        if (words.length == 0) return res;
        Map<String, Integer> wordsMap = charMapOfString(words);
        List<Map.Entry<String, Integer>> wordsEntryList = new ArrayList<>(wordsMap.entrySet());

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == (o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else return o1.getValue() > o2.getValue() ? -1 : 1;

            }
        };

        Collections.sort(wordsEntryList, valueComparator);
        for (int i=0;i <k;i++){
            res.add(wordsEntryList.get(i).getKey());
        }

        return res;
    }

    private Map<String, Integer> charMapOfString(String[] s) {
        Map<String, Integer> charMap = new LinkedHashMap<>();
        if (s.length == 0) return charMap;
        for (String c : s) {
            Integer value = charMap.containsKey(c) ? charMap.get(c) + 1 : 1;
            charMap.put(c, value);
        }
        return charMap;
    }

}


