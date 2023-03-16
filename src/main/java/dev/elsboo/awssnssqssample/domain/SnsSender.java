package dev.elsboo.awssnssqssample.domain;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import dev.elsboo.awssnssqssample.infra.aws.AwsConfig;
import dev.elsboo.awssnssqssample.infra.aws.AwsProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SnsSender {
    private final AmazonSNS amazonSNS;
    private final AwsProperty awsProperty;

    public void send(String message) {
        PublishRequest publishRequest = new PublishRequest()
                .withTopicArn(awsProperty.getSnsArn())
                .withMessage(message);
        amazonSNS.publish(publishRequest);
    }
}
