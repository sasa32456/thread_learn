package com.n33.thread.learn.designpattern.guardedsuspension;

import java.util.LinkedList;

/**
 * guarded suspension
 * 确保挂起
 *
 * @author N33
 * @date 2019/4/29
 */
public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            while (queue.size() <= 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }

            return queue.removeFirst();
        }
    }


    public void putRequest(Request request) {
        synchronized (queue) {
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
