package seb.xmpl.micro.tasklist.api;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TaskList {
    private final UUID id;
    private final String name;
    private final List<Task> tasks;
}
