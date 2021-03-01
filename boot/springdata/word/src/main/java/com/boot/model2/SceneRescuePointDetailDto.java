package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 现场救援点设置 Dto
 * @author: zhanglei
 * @date: 2020-08-19 15:39:04
 */
@Data
@ApiModel(value = "SceneRescuePointDetailDto", description = "现场救援点设置")
public class SceneRescuePointDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "应急突发事件（t_event_id）", name = "eventId")
    private Long eventId;

    @ApiModelProperty(value = "救援点名称", name = "name")
    private String name;

    @ApiModelProperty(value = "救援点类型（t_category）", name = "pointType")
    private Long pointType;

    @ApiModelProperty(value = "负责人", name = "principal")
    private String principal;

    @ApiModelProperty(value = "负责人电话", name = "phone")
    private String phone;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Double latitude;

    @ApiModelProperty(value = "详细地址", name = "address")
    private String address;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

}
