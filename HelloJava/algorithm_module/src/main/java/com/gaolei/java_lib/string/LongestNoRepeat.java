package com.gaolei.java_lib.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 */
public class LongestNoRepeat {
    public static void main(String args[]) {
        String content = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(content);
        System.out.println("maxLength: " + maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> chs = new HashSet<>();
        while (j < len) {
            char current = s.charAt(j);
            if (!chs.contains(current)) {//如果右边界不重复
                ans = Math.max(ans, j - i + 1);//寻找最大值
                chs.add(s.charAt(j++));//把右边界加入chs同时右移
            } else {//右边界重复
                chs.remove(s.charAt(i++));//移除左边界同时左边界左移
            }
            System.out.println("i: " + i + "、" + "j: " + j + "、" + "chs: " + chs.toString());
        }
        return ans;
    }


}
