package com.n33.thread.learn.designpattern.future;

/**
 * Future        ->代表未来的一个凭证
 * FutureTask    ->将你的调用逻辑进行了隔离
 * FutureService ->桥接 Future和FutureTask
 *
 * @author N33
 * @date 2019/4/27
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        final String result = get();
//        System.out.println(result);


        FutureService futureService = new FutureService();
//        final Future<String> future = futureService.submit(() -> {
//            try {
//                Thread.sleep(5_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "FINISH";
//        });
        futureService.submit(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);


        System.out.println("===============");
        System.out.println("do other thing.");
        System.out.println("===============");
//        System.out.println(future.get());
//
//        System.out.println("===============");
//        System.out.println("do other thing2.");
//        System.out.println("===============");
    }

    private static String get() throws InterruptedException {
        Thread.sleep(5_000);
        return "FINISH";
    }
}
