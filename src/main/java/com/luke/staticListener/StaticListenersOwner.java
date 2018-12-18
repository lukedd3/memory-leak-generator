package com.luke.staticListener;

import java.util.LinkedList;

class StaticListenersOwner {
    private static LinkedList listeners = new LinkedList<StaticListener>();

    public void someActionCalledFromManyThreads() {
        StaticListener listener = new StaticListener();
        listeners.add(listener);
        listener.doSomeAction();
    }
}
