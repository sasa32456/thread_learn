package com.n33.thread.learn.designpattern.threadspecificstorage;

public class QueryFromDBAction {

    public void execute() {
        try {
            Thread.sleep(1000L);
            String name = "Alex " + Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
