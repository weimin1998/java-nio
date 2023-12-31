package com.weimin.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WriteClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("localhost",9527));

        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 100);
        int count = 0;
        while (true){
            count += socketChannel.read(buffer);
            System.out.println(count);
            buffer.clear();
        }
    }
}
