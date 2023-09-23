package com.weimin.buffer;

import java.nio.ByteBuffer;

import static com.weimin.buffer.ByteBufferUtil.debugAll;

public class TestGet {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        buffer.get(new byte[4]);

        debugAll(buffer);

        buffer.rewind();

        System.out.println((char) buffer.get());
    }
}
