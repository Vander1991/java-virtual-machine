package classloader.analysis.loader;

/**
 * @author : Vander
 * @date :   2021/4/24
 * @description :
 */
public class ClassLoaderPrinter {

    public static void main(String[] args) {
        System.out.println(ClassLoaderPrinter.class.getClassLoader());
    }

}
