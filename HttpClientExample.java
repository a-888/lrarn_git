package java0.nio01;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpClientExample {
    public static void main(String[] args) {
        //创建HttpCLient实例
       HttpClient httpClient= HttpClients.createDefault();
       //构造HttpGet请求
        HttpGet httpGet=new HttpGet("http://localhost:8801");
        try{
            //发送Httpget请求
            HttpResponse httpResponse=httpClient.execute(httpGet);
            //处理异常
            int statusCode=httpResponse.getStatusLine().getStatusCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            StringBuffer responseText =new StringBuffer();
            String line;
            while((line=reader.readLine())!=null){
                responseText.append(line);
            }
            System.out.println("HTTP Status Code: "+statusCode);
            System.out.println("Response Body: "+responseText.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
