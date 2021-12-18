package com.gl.java;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceQueueTest {

        private static ReferenceQueue<Object> rq = new ReferenceQueue<Object>();
        public static void main(String[] args){

//            Object obj = new Object();
//            PhantomReference<Object> pr = new PhantomReference<>(obj, rq);
//            System.out.println(pr.get());
//            obj = null;
//            System.gc();
//            System.out.println(pr.get());
//            Reference<Object> r = (Reference<Object>)rq.poll();
//            if(r!=null){
//                System.out.println("回收:"+r);
//            }
            String str="haha";
            new Thread() {
                @Override
                public void run() {
                    System.out.println(str);
                }
            }.start();

        }
    }
