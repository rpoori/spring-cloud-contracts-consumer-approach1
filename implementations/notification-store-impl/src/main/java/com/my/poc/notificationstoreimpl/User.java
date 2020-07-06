package com.my.poc.notificationstoreimpl;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    String id;
    String name;
    String email;
    String status;
}
