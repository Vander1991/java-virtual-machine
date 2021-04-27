package loader.test;

import classloader.analysis.loader.MyClassLoader;
import org.junit.Test;

/**
 * @author : Vander
 * @date :   2021-04-27
 * @description :
 */
public class MyClassLoaderTest {

    @Test
    public void testFindClass() throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\learning\\JVM\\temp");
        Class<?> stuClazz = myClassLoader.loadClass("classloader.analysis.model.Student");
        System.out.println(stuClazz.getClassLoader());
        System.out.println(stuClazz);
    }

}
