package com.weimin.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestWrite {
    public static void main(String[] args) {
        try {

            ByteBuffer buffer = UTF_8.encode("write");

            FileChannel to  = new FileOutputStream("src/main/resources/write.txt").getChannel();

            while (buffer.hasRemaining()){
                to.write(buffer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
