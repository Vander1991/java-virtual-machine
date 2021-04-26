package classloader.analysis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Vander
 * @date :   2021/4/24
 * @description :
 */
@Data
@NoArgsConstructor
public class Student {

    private int stuNo;

    private String stuName;

    public Student(int stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        System.out.println("Student Constructor");
    }

    static {
        System.out.println("static block : Student");
    }

}
