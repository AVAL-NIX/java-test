package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:  Model
 * @author: zhengxin
 * @date: 2020-09-28 10:45:33
 */
@Data
public class ElectronicDrawDto extends BaseRowModel implements Serializable {

    /**
     * 名称
     */
    @ExcelProperty(value = "名称" ,index = 0)
    private String name;

    /**
     * 图号
     */
    @ExcelProperty(value = "图号" ,index = 1)
    private String drawNumber;

    /**
     * 卷册索引号
     */
    @ExcelProperty(value = "卷册索引号" ,index = 2)
    private String index;

    /**
     * 阅读数量
     */
    private Integer viewCount;

    /**
     * 下载数量
     */
    private Integer downCount;

    /**
     * 所属间隔
     */
    @ExcelProperty(value = "所属间隔" ,index = 3)
    private String interval;

    /**
     * 所属设备
     */
    private Long equipmentDrawId;

    @ExcelProperty(value = "所属设备" ,index = 4)
    private String equipmentDrawName;

    /**
     * 所属变电站
     */
    private Long equipmentTypeId;

    @ExcelProperty(value = "所属变电站" ,index = 5)
    private String equipmentTypeName;


    @ExcelProperty(value = "图片为止" ,index = 6)
    private String imgPath;




}
