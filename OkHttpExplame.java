package java0.nio01;
import okhttp3.*;

import java.io.IOException;

public class OkHttpExplame {
    public static void main(String[] args) {
        //创建OkhttpClient实例
        OkHttpClient client = new OkHttpClient();

        //构造Http请求
        Request request=new Request.Builder()
                .url("http://localhost:8801")
                .build();
        //发送HttpGet请求
        try(Response response=client.newCall(request).execute()){

            //处理响应
            int statusCode=response.code();
            String requestBody=response.body().string();
            System.out.println(statusCode);
            System.out.println(requestBody);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
