package com.gaolei.algorithmapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        HashMap map=new HashMap(7);
        try {
            System.out.println("占用内存大小："+"测试adbc".getBytes("UTF-8").length);
            System.out.println("占用内存大小："+"测试adbc".getBytes("GBK").length);
            System.out.println("占用内存大小："+"测试adbc".getBytes("Unicode").length);
            System.out.println("占用内存大小："+"测试adbc".length());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
