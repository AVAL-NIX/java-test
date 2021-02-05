package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@SuppressWarnings("serial")
@Data
public class ExcelModel extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "模压", index = 1)
    private String name;

    @ExcelProperty(value = "地地地", index = 2)
    private String age;

    @ExcelProperty(value = "一一一", index = 3)
    private String email;

    @ExcelProperty(value = "上上上", index = 4)
    private String address;

    @ExcelProperty(value = "上夺地", index = 5)
    private String sax;

    private String heigh;

    private String last;

}
