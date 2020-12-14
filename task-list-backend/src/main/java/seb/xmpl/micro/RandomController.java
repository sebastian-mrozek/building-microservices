package seb.xmpl.micro;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;

import java.util.Random;

@Controller
@Path("random")
public class RandomController {

    @Get
    public int randomNumber() {
        return new Random().nextInt();
    }
}
