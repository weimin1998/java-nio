package com.weimin.buffer;

import java.nio.ByteBuffer;

import static com.weimin.buffer.ByteBufferUtil.debugAll;

public class TestUtil {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 向buffer中添加一个数据
        buffer.put((byte) 0x61);// 'a'
        //
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        debugAll(buffer);

        buffer.flip();
        byte b = buffer.get();
        System.out.println((char) b);
        debugAll(buffer);

        buffer.compact();

        debugAll(buffer);
    }
}
