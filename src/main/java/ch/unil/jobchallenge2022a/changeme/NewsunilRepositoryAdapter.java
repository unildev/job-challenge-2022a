package ch.unil.jobchallenge2022a.changeme;

import ch.unil.jobchallenge2022a.generated.jaxb.NewsunilType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

/**
 * Secondary (driven) adapter for operations on the repository for news. Uses Spring OXM
 * {@link Jaxb2Marshaller} to unmarshal news from corresponding XML files.
 */
@Service
public class NewsunilRepositoryAdapter implements NewsRepositoryOperationsOutputPort {

    private final NewsunilMapper newsunilMapper;

    private final Jaxb2Marshaller marshaller;

    public NewsunilRepositoryAdapter(NewsunilMapper newsunilMapper, Jaxb2Marshaller marshaller) {
        this.newsunilMapper = newsunilMapper;
        this.marshaller = marshaller;
    }

    @Override
    public News obtainNewsById(Long id) {
        try {
            return newsunilMapper.convert(readNewsunil(id));
        } catch (IOException e) {
            throw new GenericNewsError("Cannot read XML for news with ID: %d. Error: %s"
                    .formatted(id, e.getMessage()));
        }
    }

    @SuppressWarnings("unchecked")
    private NewsunilType readNewsunil(Long id) throws IOException {

        // FIXME: externalize the location of the directory for the XML files as a configurable property
        final Object newsJaxb = marshaller.unmarshal(new StreamSource(new ClassPathResource("news/news_%d.xml".formatted(id)).getInputStream()));
        return ((JAXBElement<NewsunilType>) newsJaxb).getValue();
    }
}
