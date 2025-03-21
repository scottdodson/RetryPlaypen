import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

interface RetryStrategy {
    boolean retry(int attempt, Exception e);
    long getDelay(int attempt);
}

class SimpleRetryStrategy implements RetryStrategy {
    private int retryCount = 5;

    public  SimpleRetryStrategy(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public boolean retry(int attempt, Exception e) {
        return attempt <= retryCount;
    }

    @Override
    public long getDelay(int attempt) {
        return 0;
    }
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


