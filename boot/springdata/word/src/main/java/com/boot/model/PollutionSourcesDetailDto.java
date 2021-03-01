package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: 安全监管-风险目标管理-污染源管理 Dto
 * @author: lijiayu
 * @date: 2020-05-06 10:07:34
 */
@Data
@ApiModel(value = "PollutionSourcesDetailDto", description = "安全监管-风险目标管理-污染源管理")
public class PollutionSourcesDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "污染源名称", name = "name")
    private String pollutionName;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "污染源类型", name = "categoryId")
    private Long categoryId;
    @ApiModelProperty(value = "污染源类型描述", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "污染源编号", name = "pollutionNumber")
    private String pollutionNumber;

    @ApiModelProperty(value = "法人代表", name = "legalRepresentative")
    private String legalRepresentative;

    @ApiModelProperty(value = "联系电话", name = "contactPhone")
    private String contactPhone;

    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;

    @ApiModelProperty(value = "邮编", name = "postcode")
    private String postcode;

    @ApiModelProperty(value = "主要污染物", name = "majorPollutant")
    private String majorPollutant;

    @ApiModelProperty(value = "排污量", name = "dischargeCapacity")
    private String dischargeCapacity;

    @ApiModelProperty(value = "污染源年产量", name = "annualOutput")
    private String annualOutput;

    @ApiModelProperty(value = "是否重点： 1 是, 2 否", name = "whetherFocus")
    private Integer whetherFocus;

    @ApiModelProperty(value = "地图坐标-经度", name = "longitude")
    private String longitude;

    @ApiModelProperty(value = "地图坐标-纬度", name = "latitude")
    private String latitude;

    @ApiModelProperty(value = "行政区域", name = "regionId")
    private Long regionId;
    @ApiModelProperty(value = "行政区域型描述", name = "regionName")
    private String regionName;

    @ApiModelProperty(value = "主管单位", name = "orgId")
    private Long orgId;
    @ApiModelProperty(value = "主管单位描述", name = "admOrgName")
    private String admOrgName;

    @ApiModelProperty(value = "详细地址", name = "address")
    private String address;

    @ApiModelProperty(value = "污染源规模", name = "pollutionScale")
    private String pollutionScale;

    @ApiModelProperty(value = "污染物处置存储情况", name = "disposalStorage")
    private String disposalStorage;

    @ApiModelProperty(value = "专业处理情况", name = "handingSituation")
    private String handingSituation;

    @ApiModelProperty(value = "相关环保措施", name = "environmentalProtection")
    private String environmentalProtection;

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

    @ApiModelProperty(value = "距离中心点的距离", name = "distance")
    private  Double distance;

    @ApiModelProperty(value = "附件图标", name = "icon")
    private Long icon;

    @ApiModelProperty(value = "关联的监测设备数量", name = "deviceCount")
    private Integer deviceCount;

}
