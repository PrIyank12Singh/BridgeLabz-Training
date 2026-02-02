class PerformanceTest {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 100000; i++) {
            // simulate fast Work
        }
    }

    @LogExecutionTime
    public void slowTask() {
        try {
            Thread.sleep(300);  // simulate slow work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("Normal task executed");
    }
}
