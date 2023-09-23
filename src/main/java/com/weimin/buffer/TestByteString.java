package com.weimin.buffer;


import java.nio.ByteBuffer;

import static com.weimin.buffer.ByteBufferUtil.debugAll;
import static java.nio.charset.StandardCharsets.UTF_8;

public class TestByteString {
    public static void main(String[] args) {
        //
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        //
        ByteBuffer buffer1 = UTF_8.encode("hello");
        debugAll(buffer1);


        //
        ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes());
        debugAll(wrap);

    }
}
