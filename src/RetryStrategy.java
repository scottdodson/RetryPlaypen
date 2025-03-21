import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

interface RetryStrategy {
    boolean retry(int attempt, Exception e);
    long getDelay(int attempt);
}



class fixedDelayRetryStrategy implements RetryStrategy {
    private int retryCount = 5;
    private long delay = 0;

    public fixedDelayRetryStrategy(int retryCount, long delay) {
        this.retryCount = retryCount;
        this.delay = delay;
    }

    @Override
    public boolean retry(int attempt, Exception e) {
        return retryCount < attempt;
    }

    @Override
    public long getDelay(int attempt) {
        return delay;
    }
}


