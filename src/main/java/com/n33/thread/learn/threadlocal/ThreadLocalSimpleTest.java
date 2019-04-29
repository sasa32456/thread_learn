package com.n33.thread.learn.threadlocal;

public class ThreadLocalSimpleTest {

    //private static ThreadLocal threadLocal = new ThreadLocal();
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Alex";
        }
    };

    //JVM start main thread
    public static void main(String[] args) throws InterruptedException {
        //threadLocal.set("Alex");
        Thread.sleep(1000);
        //final String value = (String) threadLocal.get();
        final String value = threadLocal.get();
        System.out.println(value);


    }
}
/**
 * This class provides thread-local variables.  These variables differ from
 * their normal counterparts in that each thread that accesses one (via its
 * {@code get} or {@code set} method) has its own, independently initialized
 * copy of the variable.  {@code ThreadLocal} instances are typically private
 * static fields in classes that wish to associate state with a thread (e.g.,
 * a user ID or Transaction ID).
 * 此类提供线程局部变量。这些变量不同于
 * 他们正常的对应物，每个线程访问一个（通过它的
 * {@code get}或{@code set}方法）有自己的，独立初始化
 * 变量的副本。 {@code ThreadLocal}实例通常是私有的
 * 希望将状态与线程关联的类中的静态字段（例如，
 * 用户ID或交易ID）。 *
 * <p>For example, the class below generates unique identifiers local to each
 * thread.
 * A thread's id is assigned the first time it invokes {@code ThreadId.get()}
 * and remains unchanged on subsequent calls.
 * <p>例如，下面的类生成每个本地的唯一标识符
 * 线程。
 * 线程的id在第一次调用时被分配{@code ThreadId.get（）}
 * 并在后续通话中保持不变。 * <pre>
 * import java.util.concurrent.atomic.AtomicInteger;
 *
 * public class ThreadId {
 *     // Atomic integer containing the next thread ID to be assigned
 *     private static final AtomicInteger nextId = new AtomicInteger(0);
 *
 *     // Thread local variable containing each thread's ID
 *     private static final ThreadLocal&lt;Integer&gt; threadId =
 *         new ThreadLocal&lt;Integer&gt;() {
 *             &#64;Override protected Integer initialValue() {
 *                 return nextId.getAndIncrement();
 *         }
 *     };
 *
 *     // Returns the current thread's unique ID, assigning it if necessary
 *     public static int get() {
 *         return threadId.get();
 *     }
 * }
 * </pre>
 * <p>Each thread holds an implicit reference to its copy of a thread-local
 * variable as long as the thread is alive and the {@code ThreadLocal}
 * instance is accessible; after a thread goes away, all of its copies of
 * thread-local instances are subject to garbage collection (unless other
 * references to these copies exist).
 * <p>每个线程都拥有对其本地线程副本的隐式引用
 * 变量只要线程处于活动状态且{@code ThreadLocal}
 * 实例可访问;一个线程消失后，它的所有副本
 * 线程局部实例受垃圾回收（除非其他
 * 存在对这些副本的引用）。 *
 *
 * @author Josh Bloch and Doug Lea
 * @since 1.2
 */
