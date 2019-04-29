package com.n33.thread.learn.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSimulator<T> {

    private final Map<Thread,T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }


    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            final T value = storage.get(key);
            if (value == null) {
                return initialValue();
            }
            return value;
        }
    }

    public T initialValue() {
        return null;
    }


}
