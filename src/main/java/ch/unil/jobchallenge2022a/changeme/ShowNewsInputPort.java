package ch.unil.jobchallenge2022a.changeme;

/**
 * Input port (boundary) for the use case of "showing" a piece of news identified by its ID.
 */
public interface ShowNewsInputPort {

    void showNews(Long id);

}
