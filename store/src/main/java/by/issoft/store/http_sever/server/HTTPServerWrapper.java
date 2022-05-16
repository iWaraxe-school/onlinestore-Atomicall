package by.issoft.store.http_sever.server;

import by.issoft.store.http_sever.server.Handlers.AddToCartHander;
import by.issoft.store.http_sever.server.Handlers.LoadDataFromDBHandler;
import by.issoft.store.http_sever.server.Handlers.MainHandler;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


public class HTTPServerWrapper {
    private static HTTPServerWrapper serverWrapper = null;
    HttpServer httpServer;
    private static final int port= 8008;
    public static HTTPServerWrapper getInstance (){
        if (null == serverWrapper){
            serverWrapper = new HTTPServerWrapper();
        }
        return serverWrapper;
    }

    private HTTPServerWrapper(){
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            httpServer.setExecutor(Executors.newCachedThreadPool());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer(){
        HttpHandler MainHandler;
        BasicAuthenticator authenticator = new BasicAuthenticator("get") {
            @Override
            public boolean checkCredentials(String user, String pwd) {
                return user.equals("login") && pwd.equals("pass");
            }
        };

        httpServer.createContext("/getAllCategories", new LoadDataFromDBHandler())
        .setAuthenticator(authenticator);
        httpServer.createContext("/", new MainHandler());
        httpServer.createContext("/addToCart", new AddToCartHander())
        .setAuthenticator(authenticator);
        httpServer.start();
    }


}
