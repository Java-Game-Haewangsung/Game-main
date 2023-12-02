package client.main.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TestClient {
    public static void main(String[] args) {

        try {
            int port = 18501;
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", port));

            // 입력 스트림
            // 서버에서 보낸 데이터를 받음
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // 출력 스트림
            //서버에 데이터를 송신
            OutputStream out = socket.getOutputStream();

            // 서버에 데이터 송신
            out.write("Java TCP Client!!! \n".getBytes(StandardCharsets.UTF_8));
            out.flush();
            System.out.println("데이터를 송신했습니다.");

            String line = in.readLine();
            System.out.println("서버로부터의 응답 : " + line);

            //서버 접속 끊기
            in.close();
            out.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
