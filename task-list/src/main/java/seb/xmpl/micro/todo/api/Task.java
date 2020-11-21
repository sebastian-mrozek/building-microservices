package seb.xmpl.micro.todo.api;

import lombok.Data;

import java.util.UUID;

@Data
public class Task {
    private final UUID id;
    private final String name;
    private final TaskStatus status;
    private final String description;
}
