package com.gaolei.java_lib.string;

/**
 * Description：String 中查找回文
 */
public class StringFindHuiwen {
    public static void main(String args[]) {
        String str = "yuaooabbccccbbpqqwertabbbatrewq";
        String huiwen = method1(str);
        System.out.println(">>>>>>>>>>> huiwen: " + huiwen);
    }

    private static String method1(String content) {

        int huiwenLength = 0;
        String huiwen = "";
        StringBuilder sb = new StringBuilder();

        int length = content.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                String frontStr = content.substring(j, i + 1);
                sb.delete(0, sb.length());
                sb.append(frontStr).reverse();
                if ((i + 1 + i - j + 1) < length) {
                    String backStr = content.substring(i + 1, i + 1 + i - j + 1);
                    if (sb.toString().endsWith(backStr)) {
                        int maxLength = frontStr.length() * 2;
                        if (maxLength > huiwenLength) {
                            huiwenLength = maxLength;
                            huiwen = frontStr + backStr;
                        }
                    }
                }
            }
        }
        return huiwen;
    }

}
