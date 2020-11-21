package seb.xmpl.micro.todo.mappers;

import org.mapstruct.Mapper;
import seb.xmpl.micro.todo.api.Task;
import seb.xmpl.micro.todo.api.TaskList;
import seb.xmpl.micro.todo.api.Workspace;
import seb.xmpl.micro.todo.db.DTask;
import seb.xmpl.micro.todo.db.DTaskList;
import seb.xmpl.micro.todo.db.DWorkspace;

@Mapper
public interface TaskMappers {

    DWorkspace fromApi(Workspace workspace);
    Workspace toApi(DWorkspace dWorkspace);
    DTaskList fromApi(TaskList list);
    TaskList toApi(DTaskList dList);
    DTask fromApi(Task task);
    Task toApi(DTask dTask);
}
