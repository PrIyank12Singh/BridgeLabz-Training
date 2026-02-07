import java.util.Random;

class FileDownloaderThread extends Thread {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int percent = 0; percent <= 100; percent += 25) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading "
                    + fileName + ": " + percent + "%");

            try {
                Thread.sleep(random.nextInt(500) + 200); // 200–700ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DownloadManagerThreadApproach {

    public static void main(String[] args) throws InterruptedException {

        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.setName("Downloader-1");
        t2.setName("Downloader-2");
        t3.setName("Downloader-3");

        t1.start();
        t2.start();
        t3.start();

        // Main thread waits
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
