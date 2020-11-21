package seb.xmpl.micro.tasklist;

import org.mapstruct.factory.Mappers;
import seb.xmpl.micro.tasklist.api.ITaskService;
import seb.xmpl.micro.tasklist.api.Task;
import seb.xmpl.micro.tasklist.api.TaskList;
import seb.xmpl.micro.tasklist.api.Workspace;
import seb.xmpl.micro.tasklist.db.DWorkspace;
import seb.xmpl.micro.tasklist.mappers.TaskMappers;

import java.util.Collections;
import java.util.UUID;

public class TaskService implements ITaskService {

    private final TaskMappers mappers = Mappers.getMapper(TaskMappers.class);

    @Override
    public Workspace createWorkspace(String name) {
        DWorkspace dWorkspace = new DWorkspace(UUID.randomUUID(), name, Collections.emptyList());
        dWorkspace.save();
        return mappers.toApi(dWorkspace);
    }

    @Override
    public TaskList createList(UUID workspaceId, String name) {
        return null;
    }

    @Override
    public Task createTask(UUID listId, String name) {
        return null;
    }

    @Override
    public Workspace getWorkspace(UUID workspaceId) {
        return null;
    }

    @Override
    public void moveTask(Task task, UUID listId) {

    }

    @Override
    public void moveList(TaskList list, UUID workspaceId) {

    }

    @Override
    public void updateWorkspace(Workspace workspace) {

    }

    @Override
    public void updateTaskList(TaskList list) {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteWorkspace(UUID workspaceId) {

    }

    @Override
    public void deleteTaskList(UUID listId) {

    }

    @Override
    public void deleteTask(UUID taskId) {

    }
}
