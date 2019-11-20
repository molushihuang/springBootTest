package com.xqd.javatest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 谢邱东 on 2019/11/20 13:57.
 * NO bug
 */

class ThreadTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }
}
