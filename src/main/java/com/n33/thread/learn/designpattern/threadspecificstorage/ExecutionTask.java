package com.n33.thread.learn.designpattern.threadspecificstorage;

/**
 * ThreadLocal，防止疯狂传参数，所以绑定参数(不能出现太多线程，不然内存Boom)
 * 老设计模式过时，此处使用工作常用
 * 注意线程池，当一个线程完成后清理，不然同一个线程内容会有遗留
 *
 * @author N33
 * @date 2019/5/3
 */
public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        queryAction.execute();
        System.out.println("The name query successful");
        httpAction.execute();
        System.out.println("The card id query successful");

        final Context context = ActionContext.getActionContext().getContext();


        System.out.println("The Name is " + context.getName() + " and CardId" + context.getCardId());
    }
}
