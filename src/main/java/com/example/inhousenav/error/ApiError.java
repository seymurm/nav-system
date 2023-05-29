package com.example.inhousenav.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by seymurmanafov on 2023. 05. 26..
 */

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private String code;
    private String path;
    private String error;
    private String message;
    private HttpStatus status;
    private String debugMessage;
    private LocalDateTime timestamp;

    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        return formatter.format(this.timestamp);
    }

}
