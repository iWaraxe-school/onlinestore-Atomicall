package by.issoft.store.http_sever.server;

public class Cart {
    private static Cart cart = null;
    private Cart(){

    }
    public static Cart getInstance(){
        if (null==cart){
            cart = new Cart();
        }
        return cart;
    }

}
