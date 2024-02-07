package com.hk.chatOrderPlacement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("whatsapp")
@Slf4j
public class WhatsAppController {

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage() {

        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = "https://graph.facebook.com/v18.0/228872810307724/messages";

            HttpEntity<String> request = getRequest();

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            if (response.getStatusCode().equals(HttpStatus.OK)) {
                log.info(response.getBody());
            }
            return response;
        } catch (Exception e) {
            log.error("Exception occurred while hitting meta api {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    private static HttpEntity<String> getRequest() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String accessToken = "EAAPG3fOqYT8BO7ks2eVVTHtHmd1SIsuEVBNAVkDxh0WFdeEje3k2QbM5QNWfjMwfDtrde5m7ONMCaAV3h6fn5C2AT8sf2K3ZBnQNq1AMF3fXsKGLdHXYJjfZBusdcczFCFB92mF7F93ytWoUWKh7PnWXaYCwrEbVAowLohaKawX8ubCQoLyYZCcMCnFZAHCrmICHL5ZAHZAZCt2bGHtiMLAFNgMsNVRsAZDZD";
        httpHeaders.set("Authorization", "Bearer " + accessToken);
        httpHeaders.set("Content-Type", "application/json");

        String body =  "{\"messaging_product\":\"whatsapp\",\"to\":\"919650423325\",\"type\":\"template\",\"template\":{\"name\":\"hello_world\",\"language\":{\"code\":\"en_US\"}}}";

        return new HttpEntity<>(body, httpHeaders);
    }
}
