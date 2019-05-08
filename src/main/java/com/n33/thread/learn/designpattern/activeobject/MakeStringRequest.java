package com.n33.thread.learn.designpattern.activeobject;

/**
 * {@link ActiveObject#makeString(int, char)}
 *
 * @author N33
 * @date 2019/5/8
 */
public class MakeStringRequest extends MethodRequest {
    private final int count;

    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        final Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
