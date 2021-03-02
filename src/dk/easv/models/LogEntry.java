package dk.easv.models;

import java.time.LocalDateTime;

public class LogEntry {

    private static int nextId = 1;

    private int id;
    private String message;

    public LogEntry(String message) {
        this.message = message;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
