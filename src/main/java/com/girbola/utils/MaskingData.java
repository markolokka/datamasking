package com.girbola.utils;

public class MaskingData {

    public static String maskData(String data, String replacer) {

        StringBuilder sb = new StringBuilder();
        int dataLength = data.length();
        for(int i = 0; i < dataLength; i++) {
            sb.append(replacer);
        }
        return sb.toString();

    }

}
