package seb.xmpl.micro.todo;

import org.junit.jupiter.api.Test;
import seb.xmpl.micro.todo.db.DWorkspace;
import seb.xmpl.micro.todo.db.query.QDWorkspace;

import java.util.List;

public class Playground {

    @Test
    public void test() {
        new TaskService().createWorkspace("start");
        List<DWorkspace> list = new QDWorkspace().findList();
        list.forEach(System.out::println);
    }
}
