package com.company.servingwebcontent.services;

import com.company.servingwebcontent.models.config.NotificationResponse;
import com.company.servingwebcontent.models.config.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;


@Service
public class NotificationServiceImpl implements NotificationService {
    private final Duration CONNECTION_TIMEOUT = Duration.ofSeconds(500);
    private final Duration READ_TIMEOUT = Duration.ofSeconds(500);
    private final String TRANSACTION_REQUEST_URL = "http://77.234.215.138:30021/orders/webhook";
    private ConcurrentLinkedDeque<NotificationResponse> responsesList = new ConcurrentLinkedDeque<>();
    private final RestTemplate restTemplate;

    @Autowired
    NotificationServiceImpl(final RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setReadTimeout(READ_TIMEOUT)
                .build();
    }

    @Override
    public NotificationResponse notificationRequest() {
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setId(UUID.randomUUID());
        notificationResponse.setStatus(Status.PENDING);
        notificationResponse.setSubmitTime(System.currentTimeMillis());

        responsesList.add(notificationResponse);

        return notificationResponse;
    }

    @Scheduled(fixedDelay = 1000)
    void sendCAllBacks() {
        while (!responsesList.isEmpty()) {
            NotificationResponse notificationResponse = responsesList.pollFirst();

            notificationResponse.setStatus(Status.SUCCESS);
            notificationResponse.setCost(10);
            notificationResponse.setDelta(100);
            notificationResponse.setCompletedTime(System.currentTimeMillis());

            sendCallBack(notificationResponse);
        }
    }

    void sendCallBack(NotificationResponse notificationResponse) {
        System.out.println("Sending notification for id = " + notificationResponse.getId());
        sendTransaction(notificationResponse);
    }

    public void sendTransaction(NotificationResponse notificationResponse) {

        try {
            // create a bodyMap for post parameters
            Map<String, Object> bodyMap = new HashMap<>();
            bodyMap.put("id", notificationResponse.getId());
            bodyMap.put("cost", notificationResponse.getCost());
            bodyMap.put("completedTime", notificationResponse.getCompletedTime());
            bodyMap.put("delta", notificationResponse.getDelta());
            bodyMap.put("status", notificationResponse.getStatus());
            bodyMap.put("submitTime", notificationResponse.getSubmitTime());

            // setting time for counter
            final long startTime = System.nanoTime();

            ResponseEntity<Void> response = doPost(TRANSACTION_REQUEST_URL, bodyMap, Void.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("did callback");
//                return response.getBody();
            } else {
//                return null;
                System.out.println("did callback responce failed");
            }
        }
        catch (Exception e) {
            System.out.println("External service : " + e.getMessage());
        }
    }

    private ResponseEntity doPost(final String url, Map<String, Object> bodyMap, Class responseObjectClass) {
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(bodyMap, headers);

        // send POST request
        return restTemplate.postForEntity(url, entity, responseObjectClass);
    }


}
