package ch.unil.jobchallenge2022a;

/*
    Using Spring Boot's Test output capture utility to test
    the output to the console. See
    https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#features.testing.utilities.output-capture
    for more details.
 */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@SpringBootTest
@ExtendWith({OutputCaptureExtension.class})
public class NewsProcessingApplicationOutputCaptureTestIT {

    @Test
    void processNewsAndCheckConsoleOutput(CapturedOutput output) {
        Assertions.assertThat(output).contains(
                "News(id=1, title=Guerres civiles et r\u00E9volutions)",
                "News(id=2, title=VQ: je suis musicienne et cheffe d'orchestre)",
                "News(id=3, title=CINQ A SEPT \u00ABLes infirmier\u00B7e\u00B7s praticien\u00B7ne\u00B7s sp\u00E9cialis\u00E9\u00B7e\u00B7s (IPS)\u00BB)"
        );
    }
}
