package com.luke.staticListener;

import java.util.Random;

public class StaticListenersOwnerCaller {
    private volatile int minThreadLifetime;
    private volatile int maxThreadLifetime;
    StaticListenersOwner listenersOwner;

    public StaticListenersOwnerCaller(int minThreadLifetime, int maxThreadLifetime) {
        if(minThreadLifetime < 0 || maxThreadLifetime < 1 || minThreadLifetime >= maxThreadLifetime){
            throw new IllegalArgumentException();
        }
        this.minThreadLifetime = minThreadLifetime;
        this.maxThreadLifetime = maxThreadLifetime;
        listenersOwner = new StaticListenersOwner();
        makeNewThread();
    }

    private void makeNewThread() {
        Thread thread = new Thread(() -> {
            Random random = new Random();
            try {
                listenersOwner.someActionCalledFromManyThreads();
                Thread.sleep(random.nextInt(maxThreadLifetime - minThreadLifetime) + minThreadLifetime);
                makeNewThread();
            }
            catch(InterruptedException e) {

            }
        });
        thread.start();
    }
}
