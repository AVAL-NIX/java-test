package com.boot.util;


import com.boot.model.*;
import com.boot.model2.*;
import com.lowagie.text.*;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/2/3
 */
@Slf4j
public class WordUtil {

    /**
     * 导出的路径
     *
     * @param file
     * @throws Exception
     * @throws IOException
     */
    public static void createDocContext(String file, List<com.boot.model.Table> tables)throws Exception, IOException{
        //设置纸张大小
        Document document = new Document(PageSize.A4);
        //建立一个书写器，与document对象关联
        RtfWriter2.getInstance(document, new FileOutputStream(file));
        document.open();
        //设置中文字体
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        //标题字体风格
//        Font titleFont = new Font(bfChinese,12,Font.BOLD);
//        //正文字体风格
//        Font contextFont = new Font(bfChinese,10, Font.NORMAL);
     /*   Paragraph title = new Paragraph("标题");
        //设置标题格式对齐方式
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(titleFont);
        document.add(title);*/
//        Paragraph context = new Paragraph(contextString);
//        context.setAlignment(Element.ALIGN_LEFT);
//        context.setFont(contextFont);
//        //段间距
//        context.setSpacingBefore(3);
//        //设置第一行空的列数
//        context.setFirstLineIndent(20);

//        document.add(context);
        for (com.boot.model.Table table : tables) {
            document.add(new Paragraph("表"+table.getTableName() + ""));
            WordUtil.createTable(document,table.getCols());
        }

        document.close();

    }


    /**
     * 导出的路径
     *
     * @param file
     * @throws Exception
     * @throws IOException
     */
    public static void createDocContext2(String file)throws Exception, IOException{
        //设置纸张大小
        Document document = new Document(PageSize.A4);
        //建立一个书写器，与document对象关联
        RtfWriter2.getInstance(document, new FileOutputStream(file));
        document.open();
        //设置中文字体
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        //标题字体风格
//        Font titleFont = new Font(bfChinese,12,Font.BOLD);
//        //正文字体风格
//        Font contextFont = new Font(bfChinese,10, Font.NORMAL);
     /*   Paragraph title = new Paragraph("标题");
        //设置标题格式对齐方式
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(titleFont);
        document.add(title);*/
//        Paragraph context = new Paragraph(contextString);
//        context.setAlignment(Element.ALIGN_LEFT);
//        context.setFont(contextFont);
//        //段间距
//        context.setSpacingBefore(3);
//        //设置第一行空的列数
//        context.setFirstLineIndent(20);

//        document.add(context);

//        WordUtil.createTable2(document, SceneRescuePointDetailDto.class);
//        WordUtil.createTable2(document, SceneRescueTaskDetailDto.class);
//        WordUtil.createTable2(document, SceneRescueTaskMemberDetailDto.class);
//        WordUtil.createTable2(document, SceneRescueTaskResourceDetailDto.class);
//        WordUtil.createTable2(document, SceneRescueTaskTeamDetailDto.class);
//        WordUtil.createTable2(document, UrgentMedicineRescueCasualtyDetailDto.class);
//        WordUtil.createTable2(document, UrgentMedicineRescueCasualtyTriageDetailDto.class);

//        WordUtil.createTable2(document, TransportListDto.class);
//        WordUtil.createTable2(document, ShelterPlaceDetailDto.class);
//        WordUtil.createTable2(document, RescueTeamDto.class);
//        WordUtil.createTable2(document, OrgListDto.class);
//        WordUtil.createTable2(document, MedicalOrgDetailDto.class);
//        WordUtil.createTable2(document, EquipmentDto.class);
//        WordUtil.createTable2(document, EventListDto.class);


        WordUtil.createTable2(document, GroupDto.class);

        document.close();

    }

    public static void createTable(Document document, List<TableCol> list){
        try{
            Table table = new Table(5);
//            int width[] = {15,30,15,15,10,15};//设置每列宽度比例
//            table.setWidths(width);
            table.setWidth(90);//占页面宽度比例
            table.setAlignment(Element.ALIGN_CENTER);//居中
            table.setAlignment(Element.ALIGN_MIDDLE);//垂直居中
            table.setAutoFillEmptyCells(true);//自动填满
            table.setBorderWidth(1);//边框宽度
            table.addCell("名称");
            table.addCell("列名");
            table.addCell("类型");
            table.addCell("是否必填");
            table.addCell("备注");
            table.endHeaders();

            for (TableCol tableObject : list) {
                table.addCell(new Cell(tableObject.getComment()));
                table.addCell(new Cell(tableObject.getColName()));
                table.addCell(new Cell(tableObject.getType()));
                table.addCell(new Cell(tableObject.getIsNull()));
                table.addCell(new Cell(" "));
            }

            document.add(table);
        }catch (Exception e){
            log.error("生成表格异常",e);
        }
    }

    public static void createTable2(Document document, Class clazz){
        try{
            ApiModel a = (ApiModel) clazz.getAnnotation(ApiModel.class);
            document.add(new Paragraph(""+a.description() + ""));
            Table table = new Table(5);
//            int width[] = {15,30,15,15,10,15};//设置每列宽度比例
//            table.setWidths(width);
            table.setWidth(90);//占页面宽度比例
            table.setAlignment(Element.ALIGN_CENTER);//居中
            table.setAlignment(Element.ALIGN_MIDDLE);//垂直居中
            table.setAutoFillEmptyCells(true);//自动填满
            table.setBorderWidth(1);//边框宽度
            table.addCell("名称");
            table.addCell("标识");
            table.addCell("数据类型");
            table.addCell("有效范围");
            table.addCell("输入方式");
            table.endHeaders();
//            名称	标识	数据类型	有效范围	输入方式
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                ApiModelProperty value = field.getAnnotation(ApiModelProperty.class);
                if(value == null){
                    continue;
                }
                table.addCell(new Cell(value.value()));
                table.addCell(new Cell(field.getName()));
                table.addCell(new Cell(field.getType().getTypeName()));
                table.addCell(new Cell(""));
                table.addCell(new Cell("无"));
            }

            document.add(table);
        }catch (Exception e){
            log.error("生成表格异常",e);
        }
    }


    public static void main(String[] args) {
        WordUtil word = new WordUtil();
        String file = "d://test.doc";
        try {
//            word.createDocContext(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
