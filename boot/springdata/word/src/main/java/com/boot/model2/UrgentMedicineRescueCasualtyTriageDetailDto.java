package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 紧急医学救援-伤员检伤分类 Dto
 * @author: zhanglei
 * @date: 2020-09-01 16:19:32
 */
@Data
@ApiModel(value = "UrgentMedicineRescueCasualtyTriageDetailDto", description = "紧急医学救援-伤员检伤分类")
public class UrgentMedicineRescueCasualtyTriageDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "应急突发事件（t_event_id）", name = "eventId")
    private Long eventId;

    @ApiModelProperty(value = "(伤亡人员id) t_urgent_medicine_rescue_casualty", name = "casualtyId")
    private String casualtyId;

    @ApiModelProperty(value = "伤员类型（t_category）", name = "casualtyType")
    private Long casualtyType;

    @ApiModelProperty(value = "1：男，2：女", name = "sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄", name = "age")
    private Integer age;

    @ApiModelProperty(value = "负伤地点", name = "injuryAddress")
    private String injuryAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "负伤时间", name = "injuryTime")
    private LocalDateTime injuryTime;

    @ApiModelProperty(value = "GSC评分id（t_category）", name = "gscId")
    private Long gscId;

    @ApiModelProperty(value = "心肺复苏（1:是，0：否）", name = "cpr")
    private Integer cpr;

    @ApiModelProperty(value = "伤部id(t_category),-1:表示未选中，0：表示其他", name = "injuryPartId")
    private Long injuryPartId;

    @ApiModelProperty(value = "伤类id(t_category),-1:表示未选中，0：表示其他", name = "injuryClassId")
    private Long injuryClassId;

    @ApiModelProperty(value = "伤型id(t_category),-1:表示未选中，0：表示其他", name = "injuryTypeId")
    private Long injuryTypeId;

    @ApiModelProperty(value = "并发症id(t_category),-1:表示未选中，0：表示其他", name = "complicationId")
    private Long complicationId;

    @ApiModelProperty(value = "伤部-其他内容", name = "injuryPartCustom")
    private String injuryPartCustom;

    @ApiModelProperty(value = "伤类-其他内容", name = "injuryClassCustom")
    private String injuryClassCustom;

    @ApiModelProperty(value = "伤型-其他内容", name = "injuryTypeCustom")
    private String injuryTypeCustom;

    @ApiModelProperty(value = "并发症-其他内容", name = "complicationCustom")
    private String complicationCustom;

    @ApiModelProperty(value = "伤势id(t_category)", name = "injuryId")
    private Long injuryId;

    @ApiModelProperty(value = "诊断", name = "diagnosis")
    private String diagnosis;

    @ApiModelProperty(value = "处置id(t_category),多个用逗号隔开", name = "disposeId")
    private String disposeId;

    @ApiModelProperty(value = "处置id(t_category),多个用逗号隔开", name = "directionId")
    private String directionId;

    @ApiModelProperty(value = "医生id(t_user_org)", name = "doctorId")
    private Long doctorId;

    @ApiModelProperty(value = "创建人id(t_user)", name = "createId")
    private Long createId;

    @ApiModelProperty(value = "状态（1：删除，0：正常）", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "事件名称", name = "eventName")
    private String eventName;

    @ApiModelProperty(value = "伤员名称", name = "casualtyName")
    private String casualtyName;

    @ApiModelProperty(value = "伤员分类", name = "casualtyTypeName")
    private String casualtyTypeName;

    @ApiModelProperty(value = "gsc评分", name = "gsc")
    private String gsc;

    @ApiModelProperty(value = "伤部", name = "injuryPart")
    private String injuryPart;

    @ApiModelProperty(value = "伤类", name = "injuryClass")
    private String injuryClass;

    @ApiModelProperty(value = "伤型", name = "injuryType")
    private String injuryType;

    @ApiModelProperty(value = "并发症", name = "complication")
    private String complication;

    @ApiModelProperty(value = "伤势", name = "complication")
    private String injury;

    @ApiModelProperty(value = "处置", name = "dispose")
    private String dispose;

    @ApiModelProperty(value = "去向", name = "direction")
    private String direction;

    @ApiModelProperty(value = "医生名称", name = "doctorName")
    private String doctorName;

    @ApiModelProperty(value = "创建人", name = "createName")
    private String createName;

    @ApiModelProperty(value = "医院id", name = "medicalOrgId")
    private String medicalOrgId;

    @ApiModelProperty(value = "医院名称", name = "medicalName")
    private String medicalName;

    @ApiModelProperty(value = "伤员的电话号码", name = "telephone")
    private String telephone;

}
