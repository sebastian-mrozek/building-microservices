package seb.xmpl.micro.todo.api;

import java.util.UUID;

public interface ITaskService {

    Workspace createWorkspace(final String name);
    TaskList createList(UUID workspaceId, final String name);
    Task createTask(UUID listId, String name);

    Workspace getWorkspace(UUID workspaceId);

    void moveTask(Task task, UUID listId);
    void moveList(TaskList list, UUID workspaceId);

    void updateWorkspace(Workspace workspace);
    void updateTaskList(TaskList list);
    void updateTask(Task task);

    void deleteWorkspace(UUID workspaceId);
    void deleteTaskList(UUID listId);
    void deleteTask(UUID taskId);
}
