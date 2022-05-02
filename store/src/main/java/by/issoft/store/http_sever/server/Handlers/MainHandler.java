package by.issoft.store.http_sever.server.Handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        var o = exchange.getResponseBody();
        byte[] b = "MainPage".getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, b.length);
        o.write(b);
        o.close();
    }
}
