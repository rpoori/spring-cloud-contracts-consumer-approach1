package com.my.poc.notification;

public interface NotificationStore {
    void sendPromotionalEmailsToActiveUsers(String campaignId, String userSegment);
}
