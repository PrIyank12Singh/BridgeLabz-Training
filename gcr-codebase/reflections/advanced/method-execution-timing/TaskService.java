class TaskService {

    public void fastTask() {
        for (int i = 0; i < 100000; i++) {
            // simulate work
        }
    }

    public void slowTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
