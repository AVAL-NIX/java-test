package com.boot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 应急救援队伍 Dto
 * @author: yejin
 * @date: 2020-04-15 17:29:52
 */
@Data
@ApiModel(value = "RescueTeam", description = "应急救援队伍")
public class RescueTeamDto implements Serializable {

    private static final long serialVersionUID = 1586942992949L;

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "队伍名称", name = "name")
    private String name;

    @ApiModelProperty(value = "队伍类型", name = "categoryId")
    private Long categoryId;

    @ApiModelProperty(value = "队伍类型名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "级别 1:省级，2:市级，3:县级，4:乡镇级，5:存社，6:其他", name = "level")
    private Integer level;

    @ApiModelProperty(value = "密级 1:机密，2:秘密，3:限制，4:公开，5:其他", name = "privateLevel")
    private Integer privateLevel;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "行政区划名称", name = "regionName")
    private String regionName;

    @ApiModelProperty(value = "唯一标示", name = "code")
    private String code;

    @ApiModelProperty(value = "负责人", name = "leader")
    private String leader;

    @ApiModelProperty(value = "负责人电话", name = "leaderPhone")
    private String leaderPhone;

    @ApiModelProperty(value = "值班电话", name = "dutyPhone")
    private String dutyPhone;

    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;

    @ApiModelProperty(value = "邮编", name = "postcode")
    private String postcode;

    @ApiModelProperty(value = "资质等级", name = "credential")
    private String credential;

    @ApiModelProperty(value = "总人数", name = "number")
    private Integer number;

    @ApiModelProperty(value = "成立时间", name = "setupDate")
    private String setupDate;

    @ApiModelProperty(value = "地址", name = "address")
    private String address;

    @ApiModelProperty(value = "自备交通工具", name = "selfTraffic")
    private String selfTraffic;

    @ApiModelProperty(value = "集合出发地点", name = "gatherPlace")
    private String gatherPlace;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Float longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Float latitude;

    @ApiModelProperty(value = "预计准备时间", name = "readyTime")
    private String readyTime;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    @ApiModelProperty(value = "数据来源单位名称", name = "dataSourceOrgName")
    private String dataSourceOrgName;

    @ApiModelProperty(value = "应急通讯方式", name = "egcCommnication")
    private String egcCommnication;

    @ApiModelProperty(value = "主要职责", name = "duty")
    private String duty;

    @ApiModelProperty(value = "专长描述", name = "speciality")
    private String speciality;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "主管机构id", name = "admOrgId")
    private Long admOrgId;

    @ApiModelProperty(value = "主管机构id", name = "admOrgName")
    private String admOrgName;

    @ApiModelProperty(value = "主管机构地址", name = "admOrgAddress")
    private String admOrgAddress;

    @ApiModelProperty(value = "附件图标", name = "icon")
    private Long icon;


}
