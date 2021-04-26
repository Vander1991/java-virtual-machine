package classloader.analysis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Vander
 * @date :   2021/4/25
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int teaId;

    private String teaName;

    static {
        System.out.println("static block : Teacher");
    }

}
