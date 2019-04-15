package it.sevenbits;

import java.util.*;

public class Swaper {

    public List<String> doSwap(final List<String> list) {
        Map<Character, Integer> map = new HashMap<>();
        for (String str: list) {
            map.put(str.charAt(0), list.indexOf(str));
        }
        Set<Character> collectionOFKeys = map.keySet();
        for (Character key: collectionOFKeys) {
            int index1 = map.get(key);
            for (String string: list) {
                if (key == string.charAt(0) && index1 != list.indexOf(string)) {
                    int index2 = list.indexOf(string);
                    Collections.swap(list, index1, index2);
                }
            }
        }
        return list;
    }
}
