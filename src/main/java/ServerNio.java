import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerNio {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9527));

        ByteBuffer buffer = ByteBuffer.allocate(2000);


        while (true) {
            System.out.println("connecting...");
            SocketChannel socketChannel = serverSocketChannel.accept(); // 阻塞
            System.out.println("connected..." + socketChannel);


            socketChannel.read(buffer);// 阻塞
            buffer.flip();
            StringBuilder builder = new StringBuilder();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                builder.append((char) b);
            }

            buffer.clear();
            System.out.println(builder);
            socketChannel.write(Charset.defaultCharset().encode("hello client, I'm server."));

        }
    }
}
