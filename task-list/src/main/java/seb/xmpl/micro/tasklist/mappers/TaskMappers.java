package seb.xmpl.micro.tasklist.mappers;

import org.mapstruct.Mapper;
import seb.xmpl.micro.tasklist.api.Task;
import seb.xmpl.micro.tasklist.api.TaskList;
import seb.xmpl.micro.tasklist.api.Workspace;
import seb.xmpl.micro.tasklist.db.DTask;
import seb.xmpl.micro.tasklist.db.DTaskList;
import seb.xmpl.micro.tasklist.db.DWorkspace;

@Mapper
public interface TaskMappers {

    DWorkspace fromApi(Workspace workspace);

    Workspace toApi(DWorkspace dWorkspace);

    DTaskList fromApi(TaskList list);

    TaskList toApi(DTaskList dList);

    DTask fromApi(Task task);

    Task toApi(DTask dTask);
}
