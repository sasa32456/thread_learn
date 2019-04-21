package com.n33.thread.learn.designpattern.observerparttern.threadobserver;

import com.n33.thread.learn.designpattern.observerparttern.threadobserver.ObservableRunnable;

public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
