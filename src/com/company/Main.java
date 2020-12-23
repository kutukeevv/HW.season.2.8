package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictonary = new HashMap<>();
        Map<String, String[]> bigDictionary = new HashMap<>();
        dictonary.put("человек", new String[]{"персона", "индивид", "хомосапианс"});
        dictonary.put("дом", new String[] {"жилье", "крыша","хата", "кров"});
        dictonary.put("сонный", new String[]{"уставший", "вялый", "помятый", "выжатый"});
        dictonary.put("красивый", new String[]{"прекрасный", "несравненный", "шикарный"});

        for (Map.Entry<String, String[]> item: dictonary.entrySet()) {
            System.out.println(item.getKey()+" - "+ Arrays.toString(item.getValue()));
        }

        bigDictionary.putAll(dictonary);
        for (String list1: dictonary.keySet()) {
            String key = list1;
            for (int i = 0; i < dictonary.get(key).length; i++) {
                ArrayList<String> bd = new ArrayList<>();
                Collections.addAll(bd, dictonary.get(key));
                String temp1 = bd.get(i);
                bd.set(i, key);
                String[] tArray = new String[bd.size()];
                for (int j = 0; j < bd.size(); j++) {
                    tArray[j] = bd.get(j);
                }
                bigDictionary.put(temp1, tArray);
            }
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите слово из списка");
            String word = scanner.next();
            String[] synonim = bigDictionary.get(word);
            if (synonim != null) {
                Random r = new Random();
                int i = r.nextInt(synonim.length);
                System.out.println(synonim[i]);

            } else {
                System.out.println(" Такого слово нет");
            }
        }
    }
}
