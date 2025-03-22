

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("simple retry, no delay");
        SimpleRetryStrategy simple = new SimpleRetryStrategy(5);
        Connect simpleConnection = new Connect(simple);
        simpleConnection.connectRandomFail();
        System.out.println();

        System.out.println("simple retry with delay");
        simpleConnection.connectWithDelay();
        System.out.println();

        System.out.println("retry with wait with delay");
        FixedDelayRetryStrategy fixedDelay = new FixedDelayRetryStrategy(5, 250);
        Connect fixedDelayConnection = new Connect(fixedDelay);
        fixedDelayConnection.connectWithDelay();
        System.out.println();

    }
}