package com.example.myapplication;


import android.widget.EditText;

class StringUtils {

    public static String touzi_ed_values22 = "";

    /**
     * 在数字型字符串千分位加逗号
     *
     * @param str
     * @param edtext
     * @return sb.toString()
     */

    public static String addComma(String str, EditText edtext) {

        touzi_ed_values22 = edtext.getText().toString().trim().replaceAll(",", "");

        boolean neg = false;
        if (str.startsWith("-")) {  //处理负数
            str = str.substring(1);
            neg = true;
        }
        String tail = null;
        if (str.indexOf('.') != -1) { //处理小数点
            tail = str.substring(str.indexOf('.'));
            str = str.substring(0, str.indexOf('.'));
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        for (int i = 3; i < sb.length(); i += 4) {
            sb.insert(i, ',');
        }
        sb.reverse();
        if (neg) {
            sb.insert(0, '-');
        }
        if (tail != null) {
            sb.append(tail);
        }
        return sb.toString();
    }

}
