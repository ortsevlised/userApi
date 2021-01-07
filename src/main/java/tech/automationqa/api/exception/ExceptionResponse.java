package tech.automationqa.api.exception;

import java.util.Date;
import java.util.List;

public class ExceptionResponse {
    private final Date timestamp;
    private final String message;
    private final List<String> details;

    public ExceptionResponse(Date timestamp, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

}