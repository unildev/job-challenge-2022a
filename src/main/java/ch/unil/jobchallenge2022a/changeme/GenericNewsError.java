package ch.unil.jobchallenge2022a.changeme;

/**
 * Generic error signaling that something has gone wrong when
 * retrieving or processing a piece of news.
 */
public class GenericNewsError extends RuntimeException {
    public GenericNewsError(String message) {
        super(message);
    }
}
