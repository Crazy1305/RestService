import io.swagger.jaxrs.config.DefaultJaxrsConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

    public static void main(String[] args) throws Exception {
        ResourceConfig config = new ResourceConfig();
        config.packages("restservice");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        servlet.setInitOrder(1);
        context.addServlet(servlet, "/*");

        ServletHolder apiServlet = context.addServlet(ServletContainer.class, "/api/swagger/*");
        apiServlet.setInitOrder(2);
        apiServlet.setInitParameter("com.sun.jersey.config.property.packages", "io.swagger.jaxrs.json;io.swagger.jaxrs.listing");

        // Setup Swagger servlet
        ServletHolder swaggerServlet = context.addServlet(DefaultJaxrsConfig.class, "/swagger-core");
        swaggerServlet.setInitOrder(3);
        swaggerServlet.setInitParameter("api.version", "1.0.0");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }


    }
}
