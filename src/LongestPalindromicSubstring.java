package com.company;

import java.util.ArrayList;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

            String str = "ccc";
            System.out.println("question is: " + str);
            String answer = longestPalindrome(str);
            System.out.println("answer is: " + answer);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        else if (s.length() == 1) return s;
        else {
            ArrayList<Character> resultArr = new ArrayList<>();
            char[] strArray = s.toCharArray();
            int maxIndex = strArray.length - 1;
            int min, max;
            int maxLength = 0;
            for (int i = 1; i < maxIndex * 2; i++) {
                min = (i - 1) >> 1;
                max = i - min;
                if (strArray[min] == strArray[max]) {
                    int currentLength;
                    if (max - min == 1) currentLength = 2;
                    else currentLength = 3;
                    min--;
                    max++;
                    while (min >= 0 && max <= maxIndex) {
                        if (strArray[min] != strArray[max]) break;
                        else {
                            currentLength += 2;
                            min--;
                            max++;
                        }
                    }
                    if (currentLength > maxLength) {
                        resultArr.clear();
                        maxLength = currentLength;
                        for (int a = 0; a <= (max - min - 2); a++) {
                            resultArr.add(strArray[min + a + 1]);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c: resultArr) {
                sb.append(c);
            }
            if (resultArr.size() != 0) return sb.toString();
            else {
                return sb.append(strArray[0]).toString();
            }
        }
    }
}
