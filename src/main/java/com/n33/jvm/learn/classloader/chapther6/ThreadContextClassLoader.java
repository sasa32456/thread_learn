package com.n33.jvm.learn.classloader.chapther6;

import com.n33.jvm.learn.classloader.chapther3.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 线程上下文类加载器
 *
 * SPI(Service Provider Interface)标准接口
 * rt.jar  -JDBC -BootClassLoader 当都使用规范，则外部加载器无法访问，这时候有（破坏性的）线程上下文
 *         -JNDI
 *         -JMS
 *
 * @author N33
 * @date 2019/5/15
 */
public class ThreadContextClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("");

    }

    /**
     * static {
     *         try {
     *             java.sql.DriverManager.registerDriver(new Driver());
     *         } catch (SQLException e) {
     *             throw new RuntimeException("Can't register driver!");
     *         }
     *     }
     *
     *     com.mysql.jdbc.Driver extend java.sql.Driver
     *     <clinit>()
     *
     *     @CallerSensitive
     *     public static Connection getConnection(String url,
     *         java.util.Properties info) throws SQLException {
     *         //真正执行
     *         return (getConnection(url, info, Reflection.getCallerClass()));
     *     }
     *
     *
     *      //  Worker method called by the public getConnection() methods.
     *      private static Connection getConnection(
     *             String url, java.util.Properties info, Class<?> caller) throws SQLException {
     *         // 当callerCl为null时，我们应该检查应用程序 （间接调用此类） classloader，使rt.jar外的JDBC驱动程序类可以从这里加载。
     *         ClassLoader callerCL = caller != null ? caller.getClassLoader() : null;
     *         synchronized(DriverManager.class) {
     *             // synchronize loading of the correct classloader.这时候就已经换成实现的
     *             if (callerCL == null) {
     *                 callerCL = Thread.currentThread().getContextClassLoader();
     *             }
     *         }
     *
     *         if(url == null) {
     *             throw new SQLException("The url cannot be null", "08001");
     *         }
     *
     *         println("DriverManager.getConnection(\"" + url + "\")");
     *
     *
     *         // Walk through the loaded registeredDrivers attempting to make a connection.
     *         // Remember the first exception that gets raised so we can reraise it.
     *         SQLException reason = null;
     *
     *         // List of registered JDBC drivers
     *         //private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
     *         for(DriverInfo aDriver : registeredDrivers) {
     *             // If the caller does not have permission to load the driver then
     *             // skip it.
     *             if(isDriverAllowed(aDriver.driver, callerCL)) {
     *                 try {
     *                     println("    trying " + aDriver.driver.getClass().getName());
     *                     Connection con = aDriver.driver.connect(url, info);
     *                     if (con != null) {
     *                         // Success!
     *                         println("getConnection returning " + aDriver.driver.getClass().getName());
     *                         return (con);
     *                     }
     *                 } catch (SQLException ex) {
     *                     if (reason == null) {
     *                         reason = ex;
     *                     }
     *                 }
     *
     *             } else {
     *                 println("    skipping: " + aDriver.getClass().getName());
     *             }
     *
     *         }
     *
     *         // if we got here nobody could connect.
     *         if (reason != null)    {
     *             println("getConnection failed: " + reason);
     *             throw reason;
     *         }
     *
     *         println("getConnection: no suitable driver found for "+ url);
     *         throw new SQLException("No suitable driver found for "+ url, "08001");
     *     }
     *
     */

}
