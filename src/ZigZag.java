package com.company;

public class ZigZag {

    public static void main(String[] args) {
            String s = "ASDSDSDSD";
            int rows = 1;
            ZigZag m = new ZigZag();
            String result = m.convert(s, rows);
            System.out.println(result);
    }

    public String convert (String s, int numRows) {
        if (s == null || s == "") return null;
        if (numRows == 1) return s;
        char[] input = s.toCharArray();
        int unit = numRows * 2 - 2;
        char[][] temp = new char[numRows][(s.length() + 1 >> 1)];
        for (int i = 0; i < s.length(); i++) {
            int column = (i / unit) * unit / 2;
            int mod = Math.floorMod(i, unit);
            if (mod < numRows) {
                temp[mod][column] = input[i];
            } else {
                temp[unit - mod][column + mod - numRows + 1] = input[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < (s.length() + 1 >> 1); c++) {
                if (temp[r][c] != '\u0000') sb.append(temp[r][c]);
            }
        }
        return sb.toString();

    }

}
