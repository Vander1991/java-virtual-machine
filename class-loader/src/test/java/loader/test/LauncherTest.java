package loader.test;

import org.junit.Test;
import sun.misc.Launcher;

/**
 * @author : Vander
 * @date :   2021-04-26
 * @description :
 */
public class LauncherTest {

    @Test
    public void testLoadClass() throws ClassNotFoundException {
        Launcher launcher = new Launcher();
        ClassLoader classLoader = launcher.getClassLoader();
        classLoader.loadClass("classloader.analysis.model.Student");
        System.out.println(classLoader);
    }

}
