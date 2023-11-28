package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Map;

public class ErroResponse {

    private String title;

    private String message;

    private Map<String, String> details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;


    public ErroResponse(String title, String message, Map details) {
        this.title = title;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public ErroResponse(String title, String message) {
        this(title, message, null);
    }

    public ErroResponse(String title) {
        this(title, null);
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
