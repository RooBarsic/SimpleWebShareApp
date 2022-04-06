package com.company.servingwebcontent.models.config;

public enum Status {
    SUCCESS, // успешная транзакция
    FAILURE, // неуспешная транзакция
    PENDING // транзакция в очереди на обработку
}
