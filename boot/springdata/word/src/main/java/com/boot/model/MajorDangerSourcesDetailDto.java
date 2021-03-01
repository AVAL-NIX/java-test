package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: 重大危险源 Dto
 * @author: lijiayu
 * @date: 2020-05-06 14:37:58
 */
@Data
@ApiModel(value = "MajorDangerSourcesDetailDto", description = "重大危险源")
public class MajorDangerSourcesDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "类型id", name = "categoryId")
    private Long categoryId;

    private String categoryName;

    @ApiModelProperty(value = "面积(平方米)", name = "square")
    private Float square;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "级别", name = "level")
    private Long level;

    @ApiModelProperty(value = "密级", name = "privateLevel")
    private Long privateLevel;

    @ApiModelProperty(value = "值班电话", name = "onDutyTelephone")
    private String onDutyTelephone;

    @ApiModelProperty(value = "值班电话1", name = "onDutyTelephone1")
    private String onDutyTelephone1;

    @ApiModelProperty(value = "值班电话2", name = "onDutyTelephone2")
    private String onDutyTelephone2;

    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;

    @ApiModelProperty(value = "人员数量", name = "personNum")
    private Integer personNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "投入使用时间", name = "startUsingTime")
    private LocalDateTime startUsingTime;

    @ApiModelProperty(value = "使用年限", name = "life")
    private Integer life;

    @ApiModelProperty(value = "危险等级", name = "dangerLevel")
    private Long dangerLevel;

    @ApiModelProperty(value = "威胁人数", name = "dangerNum")
    private Integer dangerNum;

    @ApiModelProperty(value = "灾害情况", name = "disasterInfo")
    private String disasterInfo;

    @ApiModelProperty(value = "影响范围", name = "sphereInfluence")
    private String sphereInfluence;

    @ApiModelProperty(value = "降水阈值", name = "threshold")
    private String threshold;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Double latitude;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    private String regionName;

    @ApiModelProperty(value = "地址", name = "location")
    private String location;

    @ApiModelProperty(value = "是否重点 0否1是", name = "emphasis")
    private Integer emphasis;

    @ApiModelProperty(value = "主管单位", name = "admOrgId")
    private Long admOrgId;

    private String admOrgName;

    @ApiModelProperty(value = "主管单位地址", name = "admOrgLocation")
    private String admOrgLocation;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    private String dataSourceOrgName;

    @ApiModelProperty(value = "基本情况描述", name = "description")
    private String description;

    @ApiModelProperty(value = "通信方式", name = "communicationMode")
    private String communicationMode;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "", name = "isDeleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "距离中心点的距离", name = "distance")
    private  Double distance;

    @ApiModelProperty(value = "附件图标", name = "icon")
    private Long icon;

    @ApiModelProperty(value = "关联的监测设备数量", name = "deviceCount")
    private Integer deviceCount;

}
