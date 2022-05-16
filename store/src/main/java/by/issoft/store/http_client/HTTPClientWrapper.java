package by.issoft.store.http_client;


import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import by.issoft.domain.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class HTTPClientWrapper {
    HttpClient httpClient;
    String URI_Template;

    public HTTPClientWrapper(int port) {
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("login", "pass".toCharArray());
                    }
                })
                .build();
        URI_Template = "http://127.0.0.1:" + port;
    }

    private HttpResponse<byte[]> sendRequestAndGetResponse(HttpRequest request) {
        HttpResponse<byte[]> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            if (response.statusCode() > 400) {
                System.out.printf("400 or 500 Erros; response status code: %d\n on request: %s %s\n", response.statusCode(), request.method(), request.uri());
                request.headers().map().entrySet().forEach(System.out::println);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private List<List<Product>> parseDataFromDB(byte[] inputByteArray) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        ObjectReader productClassReader = objectMapper.readerFor(Product.class);
        ArrayList<List<Product>> listOfPopulatedProductLists = new ArrayList<>();
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        try {
            rootNode = objectMapper.readTree(inputByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayNode PhoneCategoryNode = (ArrayNode) rootNode.get("Phone");
        PhoneCategoryNode.forEach((node) -> {
            try {
                listOfPopulatedProductLists.get(0).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayNode BikeCategoryNode = (ArrayNode) rootNode.get("Bike");
        BikeCategoryNode.forEach((node) -> {
            try {
                listOfPopulatedProductLists.get(1).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayNode MilkCategoryNode = (ArrayNode) rootNode.get("Milk");
        MilkCategoryNode.forEach((node) -> {
            try {
                listOfPopulatedProductLists.get(2).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return listOfPopulatedProductLists;
    }
    public List<List<Product>> requestDataFromDB() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(URI_Template + "/getAllCategories")).build();
        List<List<Product>> dataFromDB = null;
        HttpResponse<byte[]>  response = sendRequestAndGetResponse(request);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (response.body().toString().equals("")) {
            System.out.println("Nothing was retrieved form DB");
            return dataFromDB;
        }
        dataFromDB = parseDataFromDB (response.body());
        return dataFromDB;
    }

    public void addToCart(Product p) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(URI_Template + "/addToCart?ProductId=" + p.getId() +
                "&ProductName=" + p.getName().replace(" ", "_"))).build();
        System.out.println("Req: " + URI_Template + "/addToCart?ProductId=" + p.getId() +
        "&ProductName=" + p.getName().replace(" ", "_"));
        var response = sendRequestAndGetResponse(request);
        System.out.println(new String(response.body(), StandardCharsets.UTF_8));
    }
}
