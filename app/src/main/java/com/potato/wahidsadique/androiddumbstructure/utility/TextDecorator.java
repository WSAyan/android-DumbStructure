package com.potato.wahidsadique.androiddumbstructure.utility;

import java.util.List;

/**
 * Created by wahid.sadique on 2/2/2018.
 */

public class TextDecorator {
    public static String listToCommaSeparatedString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (String string : stringList) {
            stringBuilder.append(string);
            index++;
            if (index != stringList.size()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
