package ch.unil.jobchallenge2022a.changeme;

import lombok.RequiredArgsConstructor;

/**
 * Implementation of a simple use case: retrieve a piece of news from repository and
 * present it.
 */
@RequiredArgsConstructor
public class ShowNewsUseCase implements ShowNewsInputPort {

    private final ShowNewsOutputPort presenter;

    private final NewsRepositoryOperationsOutputPort newsRepositoryOps;

    @Override
    public void showNews(Long id) {
        try {
            presenter.presentNews(newsRepositoryOps.obtainNewsById(id));
        } catch (GenericNewsError e) {
            presenter.presentError(e);
        }
    }
}
