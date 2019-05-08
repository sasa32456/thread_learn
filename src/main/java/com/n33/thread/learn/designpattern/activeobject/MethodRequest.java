package com.n33.thread.learn.designpattern.activeobject;

/**
 * 对应ActiveObject的每一个方法
 *
 * @author N33
 * @date 2019/5/8
 */
public abstract class MethodRequest {

    protected final Servant servant;

    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();

}
