package ch.unil.jobchallenge2022a.changeme;

/**
 * Output port (boundary) for presenting a piece of news.
 */
public interface ShowNewsOutputPort {

    void presentNews(News news);

    void presentError(GenericNewsError e);
}
