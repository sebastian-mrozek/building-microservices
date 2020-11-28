package seb.xmpl.micro;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;

@Controller
@Path("/tasks")
public class TaskController {

    @Get("/{id}")
    String getTask(long id) {
        return "Hi " + Long.toHexString(id);
    }

}
