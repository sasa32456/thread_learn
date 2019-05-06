package com.n33.thread.learn.designpattern.threadspecificstorage;

public class QueryFromHttpAction {

    public void execute() {
        final Context context = ActionContext.getActionContext().getContext();
        final String name = context.getName();
        final String cardId = getCardId(name);
        context.setCardId(cardId);
    }


    private String getCardId(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123" + Thread.currentThread().getId();
    }
}
