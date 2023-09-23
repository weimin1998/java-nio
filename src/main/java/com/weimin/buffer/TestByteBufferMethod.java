package com.weimin.buffer;

import java.nio.ByteBuffer;

public class TestByteBufferMethod {
    public static void main(String[] args) {

        // 从堆内存中分配
        ByteBuffer allocate = ByteBuffer.allocate(16);

        // 从直接内存中分配（物理内存）
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16);

        System.out.println(allocate.getClass());
        System.out.println(allocateDirect.getClass());


    }
}
