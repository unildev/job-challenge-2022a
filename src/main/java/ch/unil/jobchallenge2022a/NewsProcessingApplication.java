package ch.unil.jobchallenge2022a;

import ch.unil.jobchallenge2022a.changeme.ShowNewsInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class NewsProcessingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NewsProcessingApplication.class, args);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        log.info("[Application] Executing the use case for each piece of news...");
        getUseCase().showNews(1L);
        getUseCase().showNews(2L);
        getUseCase().showNews(3L);
    }

    private ShowNewsInputPort getUseCase() {
        return applicationContext.getBean(ShowNewsInputPort.class);
    }
}
