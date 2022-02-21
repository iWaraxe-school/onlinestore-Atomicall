package by.issoft.store;


import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

public class ReflectionsService {
    private static ReflectionsService service = null;
    private final Reflections reflections;

    public ReflectionsService(){
        reflections = new Reflections("by.issoft.domain");
    }


    public static  ReflectionsService getService (){
        if (null == service){
            service = new ReflectionsService();
        }
        return service;
    }
    public <T> Set<Class<? extends T>> getSubClasses (Class<T> c){ // casts??? Class<?> c
        return (Set<Class<? extends T>>)reflections.getSubTypesOf(c);
    }

    public <T> T createInstanceOf1(T c){
        T instance = null;
        try {
            Constructor constructor = (Constructor) c.getClass().getMethod("getConstructor").invoke(c);
            instance = (T) constructor.newInstance();

        }
        catch (Exception e){}
        finally {
            return instance;
        }
    }

}
