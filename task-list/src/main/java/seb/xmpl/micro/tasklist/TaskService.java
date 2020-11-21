package seb.xmpl.micro.tasklist;

import org.mapstruct.factory.Mappers;
import seb.xmpl.micro.tasklist.api.*;
import seb.xmpl.micro.tasklist.db.DTask;
import seb.xmpl.micro.tasklist.db.DTaskList;
import seb.xmpl.micro.tasklist.db.DWorkspace;
import seb.xmpl.micro.tasklist.db.query.QDTask;
import seb.xmpl.micro.tasklist.db.query.QDTaskList;
import seb.xmpl.micro.tasklist.db.query.QDWorkspace;
import seb.xmpl.micro.tasklist.mappers.TaskMappers;

import java.util.UUID;

public class TaskService implements ITaskService {

    private final TaskMappers mappers = Mappers.getMapper(TaskMappers.class);

    @Override
    public Workspace createWorkspace(String name) {
        DWorkspace dWorkspace = new DWorkspace().setName(name);
        dWorkspace.save();
        return mappers.toApi(dWorkspace);
    }

    @Override
    public TaskList createList(UUID workspaceId, String name) {
        DWorkspace dWorkspace = new QDWorkspace().id.eq(workspaceId).findOne();
        if (dWorkspace == null) {
            throw new IllegalArgumentException("Workspace with ID " + workspaceId + " does not exist");
        }
        DTaskList dTaskList = new DTaskList().setName(name);
        dWorkspace.getLists().add(dTaskList);
        dWorkspace.save();
        return mappers.toApi(dTaskList);
    }

    @Override
    public Task createTask(UUID listId, String name, String description) {
        DTaskList dTaskList = new QDTaskList().id.eq(listId).findOne();
        if (dTaskList == null) {
            throw new IllegalArgumentException("Task list with ID " + listId + " does not exist");
        }
        DTask dTask = new DTask().setName(name).setStatus(TaskStatus.OPEN).setDescription(description);
        dTaskList.getTasks().add(dTask);
        dTaskList.save();
        return mappers.toApi(dTask);
    }

    @Override
    public Workspace getWorkspace(UUID workspaceId) {
        DWorkspace dWorkspace = new QDWorkspace().id.eq(workspaceId).findOne();
        if (dWorkspace == null) {
            throw new IllegalArgumentException("Workspace with ID " + workspaceId + " does not exist");
        }
        return mappers.toApi(dWorkspace);
    }

    @Override
    public void deleteWorkspace(UUID listId) {
        new QDWorkspace().id.eq(listId).delete();
    }

    @Override
    public void deleteTaskList(UUID listId) {
        new QDTaskList().id.eq(listId).delete();
    }

    @Override
    public void deleteTask(UUID taskId) {
        new QDTask().id.eq(taskId).delete();
    }

    @Override
    public void updateTaskStatus(UUID taskId, TaskStatus status) {
        DTask dTask = new QDTask().id.eq(taskId).findOne();
        if (dTask == null) {
            throw new IllegalArgumentException("Task list with ID " + taskId + " does not exist");
        }
        dTask.setStatus(status).save();
    }
}
