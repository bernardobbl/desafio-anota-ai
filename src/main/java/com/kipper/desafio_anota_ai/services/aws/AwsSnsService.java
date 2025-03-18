package com.kipper.desafio_anota_ai.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

@Service

public class AwsSnsService {
    private final AmazonSNS snsClient;
    Topic catalogTopic;
    public AwsSnsService(AmazonSNS snsClient,@Qualifier("catalogEventsTopic") Topic catalogTopic){
        this.snsClient=snsClient;
        this.catalogTopic= catalogTopic;
    }


    public void publish(MessageDTO message) {
        System.out.println(message.message());
        this.snsClient.publish(catalogTopic.getTopicArn(), message.message());
    }
}