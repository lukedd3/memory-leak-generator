package com.luke.instanceListener;

import java.util.LinkedList;

class ListenersOwner {
    private LinkedList listeners = new LinkedList<Listener>();

    public void someActionCalledFromManyThreads() {
        Listener listener = new Listener();
        listeners.add(listener);
        listener.doSomeAction();
    }
}
