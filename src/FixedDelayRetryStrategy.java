import java.util.concurrent.TimeUnit;

class FixedDelayRetryStrategy implements RetryStrategy {
    private int retryCount = 5;
    private long delay = 0;

    public FixedDelayRetryStrategy(int retryCount, long delay) {
        this.retryCount = retryCount;
        this.delay = delay;
    }

    @Override
    public boolean retry(int attempt, Exception e) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(delay);
        return attempt < retryCount;
    }

    @Override
    public long getDelay(int attempt) {
        return delay;
    }
}


