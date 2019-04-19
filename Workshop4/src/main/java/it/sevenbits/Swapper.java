package it.sevenbits;

import java.util.*;

/**
 * Class with doSwap function
 */
public class Swapper {


    /**
     * doSwap function swaps strings if they coincide.
     * Strings coincide if they not null and if their first characters are the same.
     * Each unique first character can be used to swap once.
     *
     * @param list - array with string elements
     * @return list with swapped elements
     */
    public List<String> doSwap(final List<String> list) {
        Map<Character, Integer> map = new HashMap<>();
        for (String str : list) {
            if (str != null && str != "") {
                if (map.get(str.charAt(0)) == null) {
                    map.put(str.charAt(0), list.indexOf(str));
                }
            }
        }
        Set<Character> collectionOFKeys = map.keySet();
        for (Character key : collectionOFKeys) {
            int index1 = map.get(key);
            for (String string : list) {
                if (string != null && string != "") {
                    if (key == string.charAt(0) && index1 != list.indexOf(string)) {
                        int index2 = list.indexOf(string);
                        Collections.swap(list, index1, index2);
                        break;
                    }
                }
            }
        }
        return list;
    }
}
