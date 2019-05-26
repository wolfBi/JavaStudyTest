package com.bjl.object.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class NIOTest {
    public static final String FILE_PATH ="F:\\tmp\\fileServer\\io.txt";

    public static void main(String[] args) {
        try {
            study();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void study() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        //分配48字节capacity的ByteBuffer
        ByteBuffer buf = ByteBuffer.allocate(48);
        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
            buf.flip();  //make buffer ready for read
            while(buf.hasRemaining()){
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }
            //有两种方式能清空缓冲区：调用clear()或compact()方法。
            // clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。
            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    public static void study2() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "rw");
        Channel channel = aFile.getChannel();
        Selector selector = Selector.open();
//        channel.configureBlocking(false);
//        SelectionKey selectionKey = channel.register(selector,
//                Selectionkey.OP_READ);
//        int readySet = selectionKey.readyOps();
//        selectionKey.isAcceptable();
//        selectionKey.isConnectable();
//        selectionKey.isReadable();
//        selectionKey.isWritable();
//        Channel channel  = selectionKey.channel();
//        Selector selector = selectionKey.selector();
//
//        selectionKey.attach(theObject);
//        Object attachedObj = selectionKey.attachment();
//
//        SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);
//        Set selectedKeys = selector.selectedKeys();
//        Iterator keyIterator = selectedKeys.iterator();
//        while(keyIterator.hasNext()) {
//            SelectionKey key = keyIterator.next();
//            if(key.isAcceptable()) {
//                // a connection was accepted by a ServerSocketChannel.
//            } else if (key.isConnectable()) {
//                // a connection was established with a remote server.
//            } else if (key.isReadable()) {
//                // a channel is ready for reading
//            } else if (key.isWritable()) {
//                // a channel is ready for writing
//            }
//            keyIterator.remove();
//        }
    }
}
