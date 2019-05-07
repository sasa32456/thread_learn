package com.n33.thread.learn.designpattern.twophasetermination.socketserver;

import java.io.*;
import java.net.Socket;

/**
* 重点学习（笑话消化，有空再说）
*
* @author N33
* @date 2019/5/7
*/
public class ClientHandler implements Runnable {

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream)
        ) {
            while (running) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("Come from client > " + message);
                printWriter.write("echo " + message + "\n");
                printWriter.flush();
            }
        } catch (IOException e) {
            this.running = false;
            e.printStackTrace();
        } finally {
            this.stop();
        }
    }

    public void stop() {
        if (!running) {
            return;
        }

        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
