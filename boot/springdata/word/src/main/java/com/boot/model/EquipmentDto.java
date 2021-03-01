package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description: 应急救援设备 Dto
 * @author: lijiayu
 * @date: 2020-04-18 17:19:36
 */
@Data
@ApiModel(value = "EquipmentDto", description = "应急救援设备")
public class EquipmentDto {


    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "设备类别id", name = "categoryId")
    private Long categoryId;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "级别 1:省级，2:市级，3:县级，4:乡镇级，5:存社，6:其他", name = "level")
    private Integer level;

    @ApiModelProperty(value = "设备数量", name = "equipmentNum")
    private Integer equipmentNum;

    @ApiModelProperty(value = "密级 1:机密，2:秘密，3:限制，4:公开，5:其他", name = "privateLevel")
    private Integer privateLevel;

    @ApiModelProperty(value = "组织id", name = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "存放地点", name = "location")
    private String location;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Float longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Float latitude;

    @ApiModelProperty(value = "负责人", name = "manager")
    private Long manager;

    @ApiModelProperty(value = "应急电话", name = "emergencyTelphone")
    private String emergencyTelphone;

    @ApiModelProperty(value = "应急手机", name = "emergencyPhone")
    private String emergencyPhone;

    @ApiModelProperty(value = "应急电话1", name = "emergencyTelphone1")
    private String emergencyTelphone1;

    @ApiModelProperty(value = "应急电话2", name = "emergencyTelphone2")
    private String emergencyTelphone2;

    @ApiModelProperty(value = "应急手机1", name = "emergencyPhone1")
    private String emergencyPhone1;

    @ApiModelProperty(value = "应急手机2", name = "emergencyPhone2")
    private String emergencyPhone2;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "保质期", name = "expireDate")
    private LocalDate expireDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "需要更换时间", name = "replaceTime")
    private LocalDate replaceTime;

    @ApiModelProperty(value = "出库及准备时间（分钟）", name = "readyTime")
    private Integer readyTime;

    @ApiModelProperty(value = "状态 1:正常 2:报废", name = "status")
    private Integer status;

    @ApiModelProperty(value = "日常使用情况", name = "useState")
    private String useState;

    @ApiModelProperty(value = "主要性能参数", name = "performance")
    private String performance;

    @ApiModelProperty(value = "运输方式", name = "transportType")
    private String transportType;

    @ApiModelProperty(value = "通信方式", name = "communicationMode")
    private String communicationMode;

    @ApiModelProperty(value = "起运站点", name = "startSite")
    private String startSite;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    @ApiModelProperty(value = "主管单位", name = "admOrgId")
    private Long admOrgId;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

}
