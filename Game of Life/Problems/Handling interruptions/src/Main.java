class CounterThread extends Thread {
    private long counter;

    @Override
    public void run() {
        counter = 0;

        while (true) {
            counter++;
            if (interrupted()) {
                System.out.println("It was interrupted");
                break;
            }
        }
    }

    public long getCounter() {
        return counter;
    }
}