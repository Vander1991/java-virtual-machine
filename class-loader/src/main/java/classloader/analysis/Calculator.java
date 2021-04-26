package classloader.analysis;

import classloader.analysis.model.Student;
import classloader.analysis.model.Teacher;

/**
 * @author : Vander
 * @date :   2021/4/24
 * @description :
 */
public class Calculator {

    private static final int value = 2505;

    private static Student student = new Student(2010130110, "Jason");

    public int add(int a, int b) {
        int result = a + b;
        System.out.println(String.format("%s + %s = %s", a, b, result));
        return result;
    }

    public static void main(String[] args){
        Teacher teacher;
        Calculator calculator = new Calculator();
        calculator.add(3, 4);
    }

}
