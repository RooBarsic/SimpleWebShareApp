package com.company.servingwebcontent.models.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NotificationResponse {

    /** идентификатор транзакции*/
    @JsonProperty("id")
    private UUID id;

    /** Статус транзакции*/
    @JsonProperty("status")
    private Status status;

    /** Время отправки транзакции (unix timestamp)*/
    @JsonProperty("submitTime")
    private long submitTime;

    /** Время окончения обработки (unix timestamp)*/
    @JsonProperty("completedTime")
    private long completedTime;

    /** Цена обработки транзакции*/
    @JsonProperty("cost")
    private long cost;

    /** Время обработки транзакции в миллисекундах*/
    @JsonProperty("delta")
    private long delta;

    @Override
    public String toString() {
        return "id = " + id +
                "\nstatus = " + status +
                "\nsubmitTime = " + submitTime +
                "\ncompletedTime = " + completedTime +
                "\ncost = " + cost +
                "\ndelta = " + delta;
    }

}

/*
id": "e9e7dae5-549d-48e2-a08d-96f2127c780e",
"status": "PENDING",
"submitTime": 1649283893340,
"completedTime": null,
"cost": null,
"delta": 0

 */