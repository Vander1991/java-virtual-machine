package classloader.analysis.loader;

import lombok.AllArgsConstructor;

import java.io.FileInputStream;

/**
 * @author : Vander
 * @date :   2021-04-27
 * @description : 自定义类加载器，不打破双亲委派机制
 */
@AllArgsConstructor
public class MyClassLoader extends ClassLoader {

    private String classPath;

    /**
     * 重写findClass方法实现自定义的类加载
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    /**
     * 读取.class文件为二进制流
     *
     * @param name
     * @return
     * @throws Exception
     */
    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

}
