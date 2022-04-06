package com.company.servingwebcontent.controller;


import com.company.servingwebcontent.models.config.NotificationRequest;
import com.company.servingwebcontent.models.config.NotificationResponse;
import com.company.servingwebcontent.services.NotificationService;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {
    private NotificationService notificationService;

    @Autowired
    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public NotificationResponse helloRequestHandler(@RequestBody NotificationRequest notificationRequest) {
        return notificationService.notificationRequest();
    }

}
