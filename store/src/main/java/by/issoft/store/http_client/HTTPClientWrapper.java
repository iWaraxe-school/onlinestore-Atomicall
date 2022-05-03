package by.issoft.store.http_client;



import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import by.issoft.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
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
        .build();
        URI_Template = "http://127.0.0.1:" + port;
    }
    private List<List<Product>> parseDataFromDB(byte[] inputByteArray){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        ObjectReader productClassReader = objectMapper.readerFor(Product.class);
        ArrayList<List<Product>> listOfPopulatedProductLists = new ArrayList<>();
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        listOfPopulatedProductLists.add(new ArrayList<Product>());
        try {
            rootNode =  objectMapper.readTree(inputByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayNode PhoneCategoryNode = (ArrayNode) rootNode.get("Phone");
        PhoneCategoryNode.forEach((node)->{
            try {
                listOfPopulatedProductLists.get(0).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayNode BikeCategoryNode = (ArrayNode) rootNode.get("Bike");
        BikeCategoryNode.forEach((node)->{
            try {
                listOfPopulatedProductLists.get(1).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ArrayNode MilkCategoryNode = (ArrayNode) rootNode.get("Milk");
        MilkCategoryNode.forEach((node)->{
            try {
                listOfPopulatedProductLists.get(2).add(productClassReader.readValue(node));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return listOfPopulatedProductLists;
    }

    public List<List<Product>> requestDataFromDB(){
        HttpRequest request = HttpRequest.newBuilder(URI.create(URI_Template + "/getAllCategories")).build();
        List<List<Product>> dataFromDB= null;
        try {
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            dataFromDB =  parseDataFromDB((byte[])response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dataFromDB;
    }

    public void addToCart(Product p){
        HttpRequest request = HttpRequest.newBuilder(URI.create(URI_Template + "/addToCart?ProductId=" + p.getId() + "& ProductName=" + p.getName())).build();
        System.out.println("Req: " + URI_Template + "/addToCart?ProductId=" + p.getId() + "& ProductName=" + p.getName());
        try {
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
