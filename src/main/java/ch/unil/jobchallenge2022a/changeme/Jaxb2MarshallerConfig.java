package ch.unil.jobchallenge2022a.changeme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Configuration for JAXB 2 marshaller.
 */
@Configuration
public class Jaxb2MarshallerConfig {

    @Bean
    public Jaxb2Marshaller initMarshaller() {
        final Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

        // FIXME: externalize the package used for JAXB bindtings as a configurable property
        jaxb2Marshaller.setPackagesToScan("ch.unil.jobchallenge2022a.generated.jaxb");

        // FIXME: externalize the location of the XSD schema as a configurable property
        jaxb2Marshaller.setSchema(new ClassPathResource("xsd/newsunil.xsd"));

        return jaxb2Marshaller;
    }

}
