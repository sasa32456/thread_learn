package com.n33.thread.learn.designpattern.threadspecificstorage;

public class ActionContext {

    private static final ThreadLocal<Context> threadLocal = ThreadLocal.withInitial(() -> new Context());

    private static class ContextHolder {
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return ContextHolder.actionContext;
    }


    public Context getContext() {
        return threadLocal.get();
    }
}
