package classloader.analysis.loader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @author : Vander
 * @date :   2021/4/24
 * @description :
 */
public class ClassLoaderPrinter {

    public static void main(String[] args) {
        // 查看rt.jar对应的BootstrapClassLoader，为null，因为是C++实现的
        System.out.println("BootstrapClassLoader : " + String.class.getClassLoader());
        // 查看ext目录下的类加载器，为ExtClassLoader
        System.out.println("ExtClassLoader : " + DESKeyFactory.class.getClassLoader());
        // 查看本类的类加载器，为AppClassLoader
        System.out.println("AppClassLoader : " + ClassLoaderPrinter.class.getClassLoader());
        // AppClassLoader's Parent -> extClassLoader's parent -> bootstrapClassLoader
        printClassLoaderInheritance();
        // 输出各个加载器加载的文件列表
        printClassLoaderLoadedFiles();

    }

    private static void printClassLoaderInheritance() {
        System.out.println();
        System.out.println("printClassLoaderInheritance : ");
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);
    }

    private static void printClassLoaderLoadedFiles() {
        System.out.println();
        printBootstrapLoadFiles();
        printExtClassLoadFiles();
        printAppClassLoadFiles();
    }

    private static void printBootstrapLoadFiles() {
        System.out.println("BootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }

    private static void printExtClassLoadFiles() {
        System.out.println("ExtClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    private static void printAppClassLoadFiles() {
        System.out.println("AppClassloader加载以下文件：");
        String[] jars = System.getProperty("java.class.path").split(";");
        for (String jarPath : jars) {
            System.out.println(jarPath);
        }
    }
}
