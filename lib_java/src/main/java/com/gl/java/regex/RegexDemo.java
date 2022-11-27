package com.gl.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String args[]) {

        matchPicture();
    }

    public static void matchBrace() {
        String content = "一二三四五六七八九十{0} 1234567890{2}，你被盟主升级到等级{1}";
        Pattern pattern = Pattern.compile("\\{[0-9]\\d*\\}");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            //每一个符合正则的字符串
            String e = matcher.group();
            System.out.println("start(): " + matcher.start());
            System.out.println("end(): " + matcher.end());
            System.out.println(e);
        }
    }

    public static void matchNum() {
        String a = "love23next234csdn3423javaeye";
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        System.out.println(m.replaceAll("").trim());
    }

    public static void matchPhoneNum() {

        String regex = "1[35789]\\d{9}";
        String s = "我的手机号是18837112195，曾经用过18888888888，还用过18812345678";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        while (m.find()) { //一定需要先查找再调用group获取电话号码
            System.out.println(m.group());
        }
    }

    public static void matchStrAndReplace() {

        // 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
        String patt = "\\bfavor\\b";

        // 用于测试的输入字符串
        String input = "Do me a favor? Fetch my favorites.AAA favor BBB";
        Pattern p = Pattern.compile(input);
        Matcher m = p.matcher(patt);

        System.out.println("ReplaceAll:" + m.replaceAll("favour"));
    }

    private static void matchPicture() {

        String line = "[\"http://yjj-img-main.oss-cn-hangzhou.aliyuncs.com/1440227044447Capture One Session5324.jpg\","
                + "\"http://yjj-img-main.oss-cn-hangzhou.aliyuncs.com/1440227044463网漏肩中长上衣.png\","
                + "\"http://yjj-img-main.oss-cn-hangzhou.aliyuncs.com/1440227044451Capture One Session5322.jpg\","
                + "\"http://yjj-img-main.oss-cn-hangzhou.aliyuncs.com/1440227044427Capture One Session5326.jpg\"]";

        Pattern pattern = Pattern.compile("http://(?!(\\.jpg|\\.png)).+?(\\.jpg|\\.png)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println();
        }
    }
}
