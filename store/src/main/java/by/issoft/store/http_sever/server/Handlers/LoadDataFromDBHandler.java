package by.issoft.store.http_sever.server.Handlers;

import by.issoft.store.http_sever.server.HTTPServer_DB_Loader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class LoadDataFromDBHandler implements HttpHandler {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        HTTPServer_DB_Loader db_loader = new HTTPServer_DB_Loader();
        var dataFromDb = db_loader.getListsOfProducts();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectNode rootNode = objectMapper.createObjectNode();
        ArrayNode productsList = rootNode.putArray("Bike");
        productsList.add (objectMapper.convertValue(dataFromDb.get(0), ArrayNode.class));
        productsList = rootNode.putArray("Milk");
        productsList.add (objectMapper.convertValue(dataFromDb.get(1), ArrayNode.class));
        productsList = rootNode.putArray("Phone");
        productsList.add (objectMapper.convertValue(dataFromDb.get(2), ArrayNode.class));
        objectMapper.writeValue(out, rootNode);
        exchange.sendResponseHeaders(200, out.toByteArray().length);
        exchange.getResponseBody().write(out.toByteArray());
        exchange.close();
    }
}
