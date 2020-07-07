package com.my.poc.springcloudcontractsconsumerapproach1;

import com.my.poc.notification.NotificationStore;
import com.my.poc.notificationstoreimpl.NotificationStoreImpl;
import com.my.poc.notificationstoreimpl.UserServiceConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConfigurationProperties("user-service")
    public UserServiceConfig userServiceConfig() {
        return new UserServiceConfig();
    }

    @Bean
    public NotificationStore notificationStore(
            RestTemplate restTemplate,
            UserServiceConfig userServiceConfig
    ) {
        return new NotificationStoreImpl(restTemplate, userServiceConfig);
    }
}
