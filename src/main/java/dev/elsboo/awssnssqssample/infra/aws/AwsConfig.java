package dev.elsboo.awssnssqssample.infra.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import dev.elsboo.awssnssqssample.infra.aws.AwsProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {
    private final AwsProperty awsProperty;

    /**
     * set AWS SNS
     * @return
     */
    @Bean
    public AmazonSNS amazonSNS() {
        AmazonSNS amazonSNS = AmazonSNSClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(getCredentials()))
                .withRegion(Regions.fromName(awsProperty.getRegion()))
                .build();
        return amazonSNS;
    }

    /**
     * set AWS SQS
     * @return
     */
    @Bean
    public AmazonSQS amazonSQS() {
        AmazonSQS amazonSQS = AmazonSQSClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(getCredentials()))
                .withRegion(Regions.fromName(awsProperty.getRegion()))
                .build();
        return amazonSQS;
    }

    private BasicAWSCredentials getCredentials() {
        return new BasicAWSCredentials(awsProperty.getAccessKey(), awsProperty.getSecretKey());
    }


}