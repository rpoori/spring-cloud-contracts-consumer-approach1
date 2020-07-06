package com.my.poc.notificationstoreimpl;

import com.my.poc.notification.NotificationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public class NotificationStoreImpl implements NotificationStore {

    private final RestTemplate restTemplate;
    private final UserServiceConfig config;

    @Override
    public void sendPromotionalEmailsToActiveUsers(String campaignId, String userSegment) {

        List<User> userList = getUserList(userSegment);

        // Code for sending emails to above user list
    }

    protected List<User> getUserList(String userSegment) {

        URI uri = UriComponentsBuilder.fromHttpUrl(config.getRestApiUrl())
                .pathSegment("api", "user", "active", "{segment}")
                .buildAndExpand(userSegment)
                .toUri();

        RequestEntity<Void> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);


        return this.restTemplate.exchange(
                requestEntity,
                new ParameterizedTypeReference<List<User>>() {
                }
        ).getBody();
    }
}
