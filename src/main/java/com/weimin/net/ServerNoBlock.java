package com.weimin.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.weimin.buffer.ByteBufferUtil.debugRead;

public class ServerNoBlock {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);// 非阻塞
        serverSocketChannel.bind(new InetSocketAddress(9527));

        ByteBuffer buffer = ByteBuffer.allocate(16);

        List<SocketChannel> channels = new ArrayList<SocketChannel>();

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept(); // 受serverSocketChannel.configureBlocking的影响
            if (socketChannel != null) {
                System.out.println("connected..." + socketChannel);
                socketChannel.configureBlocking(false); // 非阻塞
                channels.add(socketChannel);
            }

            for (SocketChannel channel : channels) {
                int read = channel.read(buffer);// 受socketChannel.configureBlocking的影响
                if (read > 0) {
                    buffer.flip();
                    debugRead(buffer);
                    buffer.clear();
                    System.out.println("after read.." + channel);
                }
            }
        }
    }
}
