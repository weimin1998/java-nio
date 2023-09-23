package com.weimin.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannel {
    public static void main(String[] args) {
        try {
            FileChannel from  = new FileInputStream("src/main/resources/from").getChannel();
            FileChannel to  = new FileOutputStream("src/main/resources/to").getChannel();

            from.transferTo(0,from.size(),to);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
