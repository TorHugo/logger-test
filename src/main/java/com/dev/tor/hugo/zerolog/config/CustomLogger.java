package com.dev.tor.hugo.zerolog.config;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomLogger {
    private final BlockingQueue<ByteBuffer> logQueue = new ArrayBlockingQueue<>(100);

    public CustomLogger(Path logFilePath) {
        Thread.startVirtualThread(() -> {
            try (FileChannel fileChannel = FileChannel.open(logFilePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                while (!Thread.currentThread().isInterrupted() && !logQueue.isEmpty()) {
                    ByteBuffer buffer = logQueue.take();
                    fileChannel.write(buffer);
                    buffer.clear();
                }
            } catch (InterruptedException | IOException e) {
                this.info(e.getMessage());
            }
        });
    }

    public void info(String message) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.put(message.getBytes());
        buffer.flip();
    }
}
