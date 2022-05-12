package ch.unil.jobchallenge2022a.changeme;

/**
 * Output port (boundary) for operations on the repository for news.
 */
public interface NewsRepositoryOperationsOutputPort {

    News obtainNewsById(Long id);

}
