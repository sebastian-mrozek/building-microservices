package seb.xmpl.micro;

import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin server = Javalin.create();
        WebRoutesRegistration.init(server);
        server.start();
    }
}
