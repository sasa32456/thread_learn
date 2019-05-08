package com.n33.thread.learn.designpattern.activeobject;

/**
 * 接受异步消息的主动方法
 *
 * @author N33
 * @date 2019/5/8
 */
public interface ActiveObject {

    Result makeString(int count, char fillChar);

    void displayString(String text);

}
