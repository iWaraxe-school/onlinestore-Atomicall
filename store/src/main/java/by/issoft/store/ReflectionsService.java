package by.issoft.store;


import org.reflections.Reflections;
import java.util.Set;

public class ReflectionsService {
    private static ReflectionsService service = null;
    private final Reflections reflections;
    private ReflectionsService(){
        reflections = new Reflections("by.issoft.domain");
    }

    public static  ReflectionsService getService() {
        if (null == service){
            service = new ReflectionsService();
        }
        return service;
    }

    public <T> Set<Class<? extends T>> getSubClasses (Class<T> c){
        return (Set<Class<? extends T>>)reflections.getSubTypesOf(c);
    }
}
