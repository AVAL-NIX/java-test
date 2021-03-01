package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: 重点防护目标 Dto
 * @author: zhengxin
 * @date: 2020-05-20 15:13:41
 */
@Data
@ApiModel(value = "ImportantProtectionTargetDetailDto", description = "重点防护目标")
public class ImportantProtectionTargetDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "类型id", name = "categoryId")
    private Long categoryId;

    @ApiModelProperty(value = "类型id描述", name = "categoryIdDesc")
    private String categoryIdDesc;

    @ApiModelProperty(value = "类型id描述", name = "categoryName")
    private String categoryName;

    public String getCategoryName() {
        return categoryIdDesc;
    }

    @ApiModelProperty(value = "面积(平方米)", name = "square")
    private Float square;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "级别 1:省级，2:市级，3:县级，4:乡镇级，5:村社，6:其他", name = "level")
    private Long level;

    @ApiModelProperty(value = "密级 1:机密，2:秘密，3:限制，4:公开，5:其他", name = "privateLevel")
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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "投入使用时间", name = "startUsingTime")
    private LocalDateTime startUsingTime;

    @ApiModelProperty(value = "使用年限", name = "life")
    private Integer life;

    @ApiModelProperty(value = "防护等级 1:特别防护，2:重要防护，3:较高防护，4:一般防护，5:其他", name = "protectLevel")
    private Long protectLevel;

    @ApiModelProperty(value = "可容纳人数", name = "admissibleNum")
    private Integer admissibleNum;

    @ApiModelProperty(value = "受灾形势", name = "sufferSituation")
    private String sufferSituation;

    @ApiModelProperty(value = "防护区域", name = "protectArea")
    private String protectArea;

    @ApiModelProperty(value = "监测方式", name = "monitorType")
    private String monitorType;

    @ApiModelProperty(value = "详情分类 1 压力容器 2 加油站 3 水库 4 储罐区 5 矿井信息 6 压力管道 7 库区 8 尾矿 9 锅炉 10 无", name = "detailsType")
    private Long detailsType;

    @ApiModelProperty(value = "是否重点", name = "isProtection")
    private Integer isProtection;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Float longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Float latitude;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "行政区划id", name = "regionIdDesc")
    private String regionIdDesc;

    @ApiModelProperty(value = "地址", name = "location")
    private String location;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrgDesc")
    private String dataSourceOrgDesc;

    @ApiModelProperty(value = "主管单位", name = "admOrgId")
    private Long admOrgId;

    @ApiModelProperty(value = "主管单位", name = "admOrgIdDesc")
    private String admOrgIdDesc;

    @ApiModelProperty(value = "主管单位", name = "admOrgName")
    private String admOrgName;

    public String getAdmOrgName() {
        return admOrgIdDesc;
    }

    @ApiModelProperty(value = "主管单位地址", name = "admOrgLocation")
    private String admOrgLocation;

    @ApiModelProperty(value = "基本情况描述", name = "description")
    private String description;

    @ApiModelProperty(value = "通信方式", name = "communicationMode")
    private String communicationMode;

    @ApiModelProperty(value = "防护措施", name = "preventionMeasures")
    private String preventionMeasures;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isDeleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "距离中心点的距离", name = "distance")
    private  Long distance;


    @ApiModelProperty(value = "附件图标", name = "icon")
    private Long icon;

}
