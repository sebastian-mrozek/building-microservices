package seb.xmpl.micro;

import io.avaje.http.api.WebRoutes;
import io.avaje.inject.SystemContext;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class Application {

    static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Javalin server = Javalin.create();

        List<WebRoutes> webRoutes = SystemContext.context().getBeans(WebRoutes.class);
        LOG.info("Found routes: {}", webRoutes);

        server.routes(() -> webRoutes.forEach(WebRoutes::registerRoutes));
        server.start();
    }
}
