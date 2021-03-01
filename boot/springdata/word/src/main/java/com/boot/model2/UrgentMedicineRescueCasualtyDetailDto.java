package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 紧急医学救援-伤亡人员管理 Dto
 * @author: zhanglei
 * @date: 2020-09-01 09:57:23
 */
@Data
@ApiModel(value = "UrgentMedicineRescueCasualtyDetailDto", description = "紧急医学救援-伤亡人员管理")
public class UrgentMedicineRescueCasualtyDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "应急突发事件（t_event_id）", name = "eventId")
    private Long eventId;

    @ApiModelProperty(value = "姓名", name = "userName")
    private String userName;

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

    @ApiModelProperty(value = "电话", name = "telephone")
    private String telephone;

    @ApiModelProperty(value = "医院(t_medical_org)", name = "medicalOrgId")
    private Long medicalOrgId;

    @ApiModelProperty(value = "伤势情况", name = "injurySituation")
    private String injurySituation;

    @ApiModelProperty(value = "处置情况", name = "disposeSituation")
    private String disposeSituation;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "状态（1：删除，0：正常）", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "伤员类型名称", name = "casualtyTypeName")
    private String casualtyTypeName;

    @ApiModelProperty(value = "事件名称", name = "eventName")
    private String eventName;

    @ApiModelProperty(value = "医院名称", name = "medicalOrgName")
    private String medicalOrgName;


}
