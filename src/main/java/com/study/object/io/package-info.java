package com.study.object.io;
/**
 * java核心知识点整理.pdf 2.8.2
 *  NIO基于Channel 和Buffer 进行操作，数据总是从通道读取到缓冲区，或者从缓冲区写入到通道中
 *
 *  选择区用于监听多个通道的事件
 *
 *  IO与NIO的区别  IO是面向流的，NIO是面向缓冲区的;
 *
 *  Channel : FileChannel  DatagramChannel   SocketChannel  ServerSocketChannel
 *  Buffer : ByteBuffer  IntBuffer  CharBuffer  LongBuffer  DoubleBuffer  FloatBuffer  ShortBuffer  MappedByteBuffer
 *
 **/