import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientNio {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //InetSocketAddress address = new InetSocketAddress("121.5.135.135", 9527);
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9527);

        ByteBuffer buffer = ByteBuffer.allocate(30);
        socketChannel.connect(address);


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1380; i++) {
            stringBuilder.append("1");
        }

        for (int i = 0; i < 120; i++) {
            stringBuilder.append("2");
        }


        socketChannel.write(Charset.defaultCharset().encode(stringBuilder.toString()));
        //socketChannel.write(Charset.defaultCharset().encode("hello server, I'm client."));

        socketChannel.read(buffer);// 阻塞
        buffer.flip();

        StringBuilder builder = new StringBuilder();
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            builder.append((char) b);
        }

        buffer.clear();
        System.out.println(builder);

        socketChannel.close();
    }
}
