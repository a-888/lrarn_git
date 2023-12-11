package java0.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {

    public static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            // HTTP 响应头部
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type: text/html;charset=utf-8");
            String body = "hello nio1";
            printWriter.println("Content-Length: " + body.getBytes().length);
            printWriter.println();  // 空行，表示头部结束

            // HTTP 响应体
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
