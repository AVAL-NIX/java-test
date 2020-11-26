package excel;

import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 单元测试
 */
public class EasyExcelTest {
    public static void main(String[] args) throws Exception {
        writeExcel();
//        readExcel();
    }

    /**
     * 写入Excel
     *
     * @throws FileNotFoundException
     * @author Lynch
     */
    private static void writeExcel() throws FileNotFoundException {
        List<ElectronicDrawDto> excelModelList = new ArrayList<ElectronicDrawDto>();
        for (int i = 0; i < 15; i++) {
            ElectronicDrawDto ElectronicDrawDto = new ElectronicDrawDto();
            ElectronicDrawDto.setName("变电站" + i);
            ElectronicDrawDto.setDrawNumber(i + "");
            ElectronicDrawDto.setIndex("卷册索引号" + i);
            ElectronicDrawDto.setInterval("所属间隔" + i);
            ElectronicDrawDto.setEquipmentDrawName("设备"+i);
            ElectronicDrawDto.setEquipmentTypeName("凤凰嘴变" );
            ElectronicDrawDto.setImgPath("111.pdf" );
            excelModelList.add(ElectronicDrawDto);
        }

        long beginTime = System.currentTimeMillis();
        OutputStream out = new FileOutputStream("D:/模拟数据/a.xlsx");
        EasyExcelUtil.writeExcelWithModel(out, excelModelList, ElectronicDrawDto.class, ExcelTypeEnum.XLSX);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("总共耗时 %s 毫秒", (endTime - beginTime)));

        excelModelList = null;
    }

    /**
     * 读取Excel
     *
     * @throws FileNotFoundException
     * @author Lynch
     */
    private static void readExcel() throws FileNotFoundException {
        try {
            InputStream is = new FileInputStream("D:/test.xlsx");
            InputStream inputStream = new BufferedInputStream(is);
            //读入文件，每一行对应一个 Model，获取 Model 列表
            List<ExcelModel> objectList = EasyExcelUtil.readExcelWithModel(inputStream, ExcelModel.class, ExcelTypeEnum.XLSX);
            for (ExcelModel excelModel : objectList) {
                System.out.println(excelModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}