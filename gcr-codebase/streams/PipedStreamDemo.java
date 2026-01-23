import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) {

        try {
            // Create streams
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis); // connect streams

            // Writer thread
            Thread writerThread = new Thread(new Writer(pos));

            // Reader thread
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error connecting piped streams: " + e.getMessage());
        }
    }

    // Writer Runnable
    static class Writer implements Runnable {

        private PipedOutputStream pos;

        public Writer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                String message = "Hello from Writer Thread!";

                for (char ch : message.toCharArray()) {
                    pos.write(ch);
                    Thread.sleep(100); // slow down to visualize flow
                }

                pos.close(); // important to signal end of data

            } catch (IOException | InterruptedException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        }
    }

    // Reader Runnable
    static class Reader implements Runnable {

        private PipedInputStream pis;

        public Reader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }

                System.out.println("\nReading completed.");
                pis.close();

            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        }
    }
}
