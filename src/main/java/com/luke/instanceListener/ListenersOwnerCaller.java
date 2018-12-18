package com.luke.instanceListener;

import java.util.Random;

public class ListenersOwnerCaller {
    private volatile int minThreadLifetime;
    private volatile int maxThreadLifetime;
    ListenersOwner listenersOwner;

    public ListenersOwnerCaller(int minThreadLifetime, int maxThreadLifetime) {
        if(minThreadLifetime < 0 || maxThreadLifetime < 1 || minThreadLifetime >= maxThreadLifetime){
            throw new IllegalArgumentException();
        }
        this.minThreadLifetime = minThreadLifetime;
        this.maxThreadLifetime = maxThreadLifetime;
        listenersOwner = new ListenersOwner();
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
