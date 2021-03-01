package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @description:
 * @author: zhanglei
 * @date: 2020-06-18 16:51
 **/
@Data
@ApiModel(value = "OrgListDto", description = "机构表")
public class OrgListDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "组织机构名称", name = "name")
    private String name;

    @ApiModelProperty(value = "组织机构父id", name = "parentId")
    private Long parentId;

    @ApiModelProperty(value = "组织类别：0-内部组织，1-外部单位", name = "type")
    private Integer type;

    @ApiModelProperty(value = "外部单位id", name = "companyId")
    private Long companyId;

    @ApiModelProperty(value = "组织区域id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "描述", name = "remark")
    private String remark;

    @ApiModelProperty(value = "创建人", name = "creater")
    private Long creater;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private java.util.Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private java.util.Date createTime;

    @ApiModelProperty(value = "排序", name = "sort")
    private  Integer sort;
}
