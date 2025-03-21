class SimpleRetryStrategy implements RetryStrategy {
    private int retryCount = 5;

    public  SimpleRetryStrategy(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public boolean retry(int attempt, Exception e) {
        return attempt < retryCount;
    }

    @Override
    public long getDelay(int attempt) {
        return 0;
    }
}