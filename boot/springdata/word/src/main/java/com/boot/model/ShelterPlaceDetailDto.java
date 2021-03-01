package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 应急避难场所 Dto
 * @author: chenhua
 * @date: 2020-04-27 13:48:56
 */
@Data
@ApiModel(value = "ShelterPlaceDetailDto", description = "应急避难场所")
public class ShelterPlaceDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "场所类别id", name = "categoryId")
    private Long categoryId;

    @ApiModelProperty(value = "场所类别name", name = "categoryId")
    private String categoryName;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "级别 关联category-1536", name = "level")
    private Integer level;

    @ApiModelProperty(value = "级别 描述", name = "level")
    private String levelDesc;

    @ApiModelProperty(value = "密级 关联category-1537", name = "privateLevel")
    private Integer privateLevel;

    @ApiModelProperty(value = "密级描述", name = "privateLevel")
    private String privateLevelDesc;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "行政区划名称", name="regionName")
    private String regionName;

    @ApiModelProperty(value = "占地面积（平方米）", name = "area")
    private Float area;

    @ApiModelProperty(value = "可容纳人数", name = "holdPeople")
    private Integer holdPeople;

    @ApiModelProperty(value = "地址", name = "location")
    private String location;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Double latitude;

    @ApiModelProperty(value = "负责人", name = "manager")
    private String manager;

    @ApiModelProperty(value = "应急电话", name = "emergencyTelphone")
    private String emergencyTelphone;

    @ApiModelProperty(value = "应急手机", name = "emergencyPhone")
    private String emergencyPhone;

    @ApiModelProperty(value = "应急电话1", name = "emergencyTelphone1")
    private String emergencyTelphone1;

    @ApiModelProperty(value = "应急手机1", name = "emergencyPhone1")
    private String emergencyPhone1;

    @ApiModelProperty(value = "应急传真", name = "emergencyFax")
    private String emergencyFax;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "投入使用时间", name = "usageTime")
    private LocalDateTime usageTime;

    @ApiModelProperty(value = "设计使用年限", name = "ageLimit")
    private Integer ageLimit;

    @ApiModelProperty(value = "抗震设防烈度", name = "seismicIntensity")
    private Integer seismicIntensity;

    @ApiModelProperty(value = "应急通信方式", name = "communicationMode")
    private String communicationMode;

    @ApiModelProperty(value = "基本情况", name = "description")
    private String description;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    @ApiModelProperty(value = "数据来源单位Name", name = "dataSourceOrgName")
    private String dataSourceOrgName;

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

    @ApiModelProperty(value = "附件图标", name = "icon")
    private Long icon;


}
