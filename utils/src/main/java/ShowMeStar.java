import java.io.File;
import java.io.IOException;
import java.lang.module.ResolvedModule;
import java.net.URL;
import java.util.*;

public class ShowMeStar {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        contextClassLoader.getClass();
    }


}
