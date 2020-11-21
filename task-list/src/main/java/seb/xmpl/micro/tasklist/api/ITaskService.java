package seb.xmpl.micro.tasklist.api;

import java.util.UUID;

public interface ITaskService {

    Workspace createWorkspace(final String name);

    TaskList createList(UUID workspaceId, final String name);

    Task createTask(UUID listId, String name, String description);

    Workspace getWorkspace(UUID workspaceId);

    void deleteWorkspace(UUID workspaceId);

    void deleteTaskList(UUID listId);

    void deleteTask(UUID taskId);

    void updateTaskStatus(UUID taskId, TaskStatus name);
}
