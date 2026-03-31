import java.util.Random;

class FileDownloadTask implements Runnable {

    private String fileName;
    private Random random = new Random();

    public FileDownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int percent = 0; percent <= 100; percent += 25) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading "
                    + fileName + ": " + percent + "%");

            try {
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DownloadManagerRunnableApproach {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new FileDownloadTask("Document.pdf"), "Downloader-1");
        Thread t2 = new Thread(new FileDownloadTask("Image.jpg"), "Downloader-2");
        Thread t3 = new Thread(new FileDownloadTask("Video.mp4"), "Downloader-3");

        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
