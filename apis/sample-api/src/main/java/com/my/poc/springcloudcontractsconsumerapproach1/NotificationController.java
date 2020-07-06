package com.my.poc.springcloudcontractsconsumerapproach1;

import com.my.poc.notification.NotificationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationStore notificationStore;

    @GetMapping("{campaignId}")
    public void invokeCampaign(@PathVariable String campaignId, @RequestParam String userSegment){
        notificationStore.sendPromotionalEmailsToActiveUsers(campaignId, userSegment);
    }
}
