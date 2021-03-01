package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 应急事件 Dto
 * @author: chenhua
 * @date: 2020-04-28 15:15:30
 */
@Data
@ApiModel(value = "EventListDto", description = "应急事件")
public class EventListDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "事件编号", name = "eventNo")
    private String eventNo;

    @ApiModelProperty(value = "事件名称", name = "eventName")
    private String eventName;

    @ApiModelProperty(value = "事件类别id", name = "eventCategoryId")
    private Long eventCategoryId;

    @ApiModelProperty(value = "事件类别name", name = "eventCategoryId")
    private String eventCategoryName;

    @ApiModelProperty(value = "事件等级。1:一般，2:较大，3:重大，4:特别重大", name = "eventLevel")
    private Integer eventLevel;

    @ApiModelProperty(value = "事件等级。1:一般，2:较大，3:重大，4:特别重大", name = "eventLevelDesc")
    private String eventLevelDesc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "事件发生时间", name = "occurTime")
    private LocalDateTime occurTime;

    @ApiModelProperty(value = "时间发生的年份", name = "occurYear")
    private Integer occurYear;

    @ApiModelProperty(value = "时间发生的月份", name = "occurMonth")
    private Integer occurMonth;

    @ApiModelProperty(value = "事发行政区划", name = "areaId")
    private Long areaId;

    @ApiModelProperty(value = "父类事件", name = "parentEventId")
    private Long parentEventId;

    @ApiModelProperty(value = "紧急程度。1:特急，2:紧急，3:常规", name = "eventDegree")
    private Integer eventDegree;

    @ApiModelProperty(value = "事发地点", name = "address")
    private String address;

    @ApiModelProperty(value = "事发原因", name = "reason")
    private String reason;

    @ApiModelProperty(value = "事件描述", name = "remark")
    private String remark;

    @ApiModelProperty(value = "状态。1:属实，2:已转机构，3:已启动预案，4:结案审核通过，5:已转机构 6已办结", name = "status")
    private Integer status;

    @ApiModelProperty(value = "状态。1:属实，2:已转机构，3:已启动预案，4:结案审核通过，5:已转机构 6已办结", name = "statusDesc")
    private String statusDesc;

    @ApiModelProperty(value = "是否被删除 0：未删除 1：已删除", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建者", name = "creater")
    private Long creater;

    @ApiModelProperty(value = "创建者组织", name = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Double latitude;

    @ApiModelProperty(value = "范围", name = "effectRadius")
    private Integer effectRadius;

}
