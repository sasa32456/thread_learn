package com.n33.thread.learn.designpattern.threadspecificstorage;

public class Context {
    private String name;
    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
