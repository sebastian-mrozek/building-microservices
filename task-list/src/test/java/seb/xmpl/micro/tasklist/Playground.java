package seb.xmpl.micro.tasklist;

import org.junit.jupiter.api.Test;
import seb.xmpl.micro.tasklist.db.DWorkspace;
import seb.xmpl.micro.tasklist.db.query.QDWorkspace;

import java.util.List;

public class Playground {

    @Test
    public void test() {
        new TaskService().createWorkspace("start");
        List<DWorkspace> list = new QDWorkspace().findList();
        list.forEach(System.out::println);
    }
}
