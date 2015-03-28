package pl.baduuum;

import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.platform.Verticle;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by Krzysztof Pawlowski on 15/03/15.
 */
public class Admin extends Verticle {

    @Override
    public void start() {

        container.deployModule("io.vertx~mod-mongo-persistor~2.0.0-final", new Handler<AsyncResult<String>>() {
            @Override
            public void handle(AsyncResult<String> event) {
                container.logger().info("Started mongo persistor");
            }
        });

        container.deployModule("io.vertx~mod-auth-mgr~2.0.0-final", new Handler<AsyncResult<String>>() {
            @Override
            public void handle(AsyncResult<String> event) {
                container.logger().info("Started auth module");
            }
        });

        String webServerConf = null;
        try {
            String webServerConfFile = getClass().getClassLoader().getResource("web-server-conf.json").getPath();
            webServerConf = new String(readAllBytes(get(webServerConfFile)));
        } catch (IOException e) {
            container.logger().error("Failed to load web-server-conf.json file.", e);
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = new JsonObject(webServerConf);
        container.deployModule("io.vertx~mod-web-server~2.0.0-final", jsonObject, new Handler<AsyncResult<String>>() {
            @Override
            public void handle(AsyncResult<String> event) {
                container.logger().info("Started web server module");
            }
        });
    }

}
