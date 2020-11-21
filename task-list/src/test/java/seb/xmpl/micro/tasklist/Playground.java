package seb.xmpl.micro.tasklist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import seb.xmpl.micro.tasklist.api.ITaskService;
import seb.xmpl.micro.tasklist.api.TaskList;
import seb.xmpl.micro.tasklist.api.Workspace;
import seb.xmpl.micro.tasklist.db.DWorkspace;
import seb.xmpl.micro.tasklist.db.query.QDWorkspace;

import java.io.IOException;
import java.util.List;

public class Playground {

    ITaskService service = new TaskService();
    ObjectMapper jsonMapper = new ObjectMapper();

    public Playground() {
        jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @Test
    public void test() {
        Workspace myFirstWorkspace = service.createWorkspace("my first workspace");
        TaskList gardeningTasks = service.createList(myFirstWorkspace.getId(), "gardening tasks");
        service.createTask(gardeningTasks.getId(), "Plant tomatoes", "3 varieties");


        List<DWorkspace> list = new QDWorkspace().findList();
        list.forEach(w -> {
            try {
                jsonMapper.writeValue(System.out, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
