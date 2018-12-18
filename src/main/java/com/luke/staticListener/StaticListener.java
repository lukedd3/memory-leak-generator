package com.luke.staticListener;

import java.util.Random;
import java.util.stream.IntStream;

class StaticListener {

    String someData;

    void doSomeAction() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(0, random.nextInt(10000)).forEach((i) -> sb.append(i));
        someData = sb.toString();
    }
}
