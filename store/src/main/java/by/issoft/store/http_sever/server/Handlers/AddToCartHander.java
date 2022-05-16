package by.issoft.store.http_sever.server.Handlers;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AddToCartHander implements HttpHandler {

    static class CartStorage {
        private static final List<String> cartStringList = new ArrayList<>();
        protected static void addToCartStringList(String entry){
            cartStringList.add(entry);
        }
        protected static byte[] getCartStringListAsByteArray(){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            cartStringList.forEach((e)->{
                try {
                    out.write(e.getBytes(StandardCharsets.UTF_8));
                    out.write('\n');
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            return out.toByteArray();
        }

    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        CartStorage.addToCartStringList(exchange.getRequestURI().toString());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(CartStorage.getCartStringListAsByteArray()); //.getBytes(StandardCharsets.UTF_8));
        exchange.sendResponseHeaders(200, out.toByteArray().length);
        exchange.getResponseBody().write(out.toByteArray());
        exchange.close();
    }
}


