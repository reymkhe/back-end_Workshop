package it.sevenbits;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Swaper swaper = new Swaper();
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ca");
        list.add("ab");
        list.add("ba");
        list.add("nm");
        list.add("cc");
        list.add("cd");
        list.add("bc");
        list.add("ac");
        list.add("vb");

        System.out.println(swaper.doSwap(list));

    }
}
