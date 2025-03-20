import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SimulateFailure {
    long failTime = 0;
    long sleepTime = 250;

    public boolean failRandom() throws IllegalAccessException {
        int max =  100;
        int min = 1;
        int threshold = 50;
        Random rand = new Random();
        int x = rand.nextInt((max - min) + 1) + min;
        if (x < threshold) {
            throw new IllegalAccessException();
        }
        return true;
    }

    public boolean sleepRandom() throws IllegalAccessException, InterruptedException {
        int max =  100;
        int min = 1;
        int threshold = 50;
        if (System.currentTimeMillis() < failTime) {
            //System.out.println("Fail during outage");
            throw new IllegalAccessException();
        }
        int random = ThreadLocalRandom.current().nextInt(min, max);
        if (random < threshold) {
            failTime = System.currentTimeMillis() + sleepTime;
            throw new IllegalAccessException();
        }
        return true;
    }
}
