package com.my.poc.notificationstoreimpl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationStoreImplTest extends BaseTest {

    private NotificationStoreImpl notificationStoreImpl;

    @Before
    public void setup() {
        notificationStoreImpl = new NotificationStoreImpl(new RestTemplate(), userServiceConfig);
    }

    @Test
    public void shouldReturnActiveUserList() {

        // this is the segment provided in producer contracts
        // the url constructed in consumer test must exactly match the one in producer contracts
        String userSegment = "MILLENIAL";

        List<User> userList = notificationStoreImpl.getUserList(userSegment);

        // This is the response from producer contracts
        assertThat(userList).containsExactlyInAnyOrder(
                User.builder()
                        .id("user-id-1")
                        .name("user-name-1")
                        .email("user-email-1@test.com")
                        .status("ACTIVE")
                        .build(),
                User.builder()
                        .id("user-id-2")
                        .name("user-name-2")
                        .email("user-email-2@test.com")
                        .status("ACTIVE")
                        .build(),
                User.builder()
                        .id("user-id-3")
                        .name("user-name-3")
                        .email("user-email-3@test.com")
                        .status("ACTIVE")
                        .build()
        );
    }

}
