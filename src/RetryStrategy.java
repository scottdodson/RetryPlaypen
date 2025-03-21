import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

interface RetryStrategy {
    boolean retry(int attempt, Exception e) throws InterruptedException;
    long getDelay(int attempt);
}
