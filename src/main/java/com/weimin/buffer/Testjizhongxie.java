package com.weimin.buffer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Testjizhongxie {
    public static void main(String[] args) {
        ByteBuffer buffer1 = UTF_8.encode("hello");
        ByteBuffer buffer2 = UTF_8.encode("world");
        ByteBuffer buffer3 = UTF_8.encode("你好");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src/main/resources/world");
            FileChannel channel = fileOutputStream.getChannel();

            channel.write(new ByteBuffer[]{buffer1,buffer2,buffer3});
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
