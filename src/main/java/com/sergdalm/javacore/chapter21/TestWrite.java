package src.main.java.com.sergdalm.javacore.chapter21;

// Write to a file numbers three times.

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestWrite {
    public static void main(String[] args) throws IOException {
        byte count = 0;
        char c = 'A';
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(
                Paths.get("resources/testText.txt"),
                StandardOpenOption.APPEND)) {
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            for (int k = 0; k < 3; k++) {
                for (int i = 0; i <25 ; i++) {
                    mBuf.put((byte) c);
                }
                mBuf.put((byte) ' ');

                mBuf.rewind();

                fChan.write(mBuf);

                mBuf.rewind();
                c++;

                    ////
//                    ByteBuffer mBuf = ByteBuffer.allocate(26);
//
//                    for(int i = 0; i < 26; i++)
//                        mBuf.put((byte) ('A' + i));
//
//                    mBuf.rewind();
//
//                    fChan.write(mBuf);
            }

        }
    }
}
