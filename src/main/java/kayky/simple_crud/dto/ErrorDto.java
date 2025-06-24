package kayky.simple_crud.dto;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErrorDto {

    private String message;
    private HttpStatus status;
    private int statusCode;
    private Instant timestamp;

    public ErrorDto(
        HttpStatus status,
        String message
    ) {
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.timestamp = Instant.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
        this.statusCode = status.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
