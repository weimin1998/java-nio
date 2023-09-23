package com.weimin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/order/105");
        URLConnection connection = url.openConnection();


        FileOutputStream fileOutputStream = new FileOutputStream("out");

        InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[1024];
        int read;
        while((read = inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,read);
        }

        inputStream.close();
        fileOutputStream.close();

    }
}
