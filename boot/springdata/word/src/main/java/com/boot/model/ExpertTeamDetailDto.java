package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 应急专家组 Dto
 * @author: zhanglei
 * @date: 2020-06-08 16:10:00
 */
@Data
@ApiModel(value = "ExpertTeamDetailDto", description = "应急专家组")
public class ExpertTeamDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "专家组类别", name = "categoryId")
    private Long categoryId;

    @ApiModelProperty(value = "专家组名称", name = "name")
    private String name;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "级别 1:省级，2:市级，3:县级，4:乡镇级，5:存社，6:其他", name = "level")
    private Long level;

    @ApiModelProperty(value = "联系电话", name = "concatPhone")
    private String concatPhone;

    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;

    @ApiModelProperty(value = "人数", name = "number")
    private Integer number;

    @ApiModelProperty(value = "负责人", name = "dutyUser")
    private String dutyUser;

    @ApiModelProperty(value = "负责人办公电话", name = "dutyOfficePhone")
    private String dutyOfficePhone;

    @ApiModelProperty(value = "负责人移动电话", name = "dutyPhone")
    private String dutyPhone;

    @ApiModelProperty(value = "负责人住宅电话", name = "dutyHousePhone")
    private String dutyHousePhone;

    @ApiModelProperty(value = "联系人", name = "concatUser")
    private String concatUser;

    @ApiModelProperty(value = "联系人办公电话", name = "concatOfficePhone")
    private String concatOfficePhone;

    @ApiModelProperty(value = "联系人移动电话", name = "concatMobile")
    private String concatMobile;

    @ApiModelProperty(value = "联系人住宅电话", name = "concatHousePhone")
    private String concatHousePhone;

    @ApiModelProperty(value = "组建单位地址", name = "createPlace")
    private String createPlace;

    @ApiModelProperty(value = "组建单位邮编", name = "postcode")
    private String postcode;

    @ApiModelProperty(value = "专家组介绍", name = "introduce")
    private String introduce;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "联系人电子邮箱", name = "email")
    private String email;

    @ApiModelProperty(value = "组建单位", name = "createOrg")
    private Long createOrg;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isdeleted")
    private Boolean isdeleted;

    @ApiModelProperty(value = "数据来源单位", name = "dataSourceOrg")
    private Long dataSourceOrg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "数据来源单位名称", name = "dataSourceOrgDesc")
    private String dataSourceOrgDesc;

    @ApiModelProperty(value = "组建单位名称", name = "createOrgDesc")
    private String createOrgDesc;

    @ApiModelProperty(value = "专家组类型名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "等级名称", name = "level")
    private String levelName;

}
