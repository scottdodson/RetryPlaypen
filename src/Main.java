

public class Main {
    public static void main(String[] args) throws Exception {

        SimpleRetryStrategy simple = new SimpleRetryStrategy(5);
        Connect simpleConnection = new Connect(simple);
        simpleConnection.connectRandomFail();

        FixedDelayRetryStrategy fixedDelay = new FixedDelayRetryStrategy(5, 250);
        Connect fixedDelayConnection = new Connect(fixedDelay);
        fixedDelayConnection.connectWithDelay();

    }
}