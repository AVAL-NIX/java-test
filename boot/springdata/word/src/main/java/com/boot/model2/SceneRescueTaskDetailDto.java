package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 现场救援点任务 Dto
 * @author: zhanglei
 * @date: 2020-08-20 10:04:09
 */
@Data
@ApiModel(value = "SceneRescueTaskDetailDto", description = "现场救援点任务")
public class SceneRescueTaskDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "应急突发事件（t_event_id）", name = "eventId")
    private Long eventId;

    @ApiModelProperty(value = "救援点类型（t_category）", name = "taskType")
    private Long taskType;

    @ApiModelProperty(value = "父任务", name = "parentId")
    private Long parentId;

    @ApiModelProperty(value = "救援点id(t_scene_rescue_point)", name = "pointId")
    private Long pointId;

    @ApiModelProperty(value = "目标", name = "target")
    private String target;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "下达时间", name = "releaseTime")
    private LocalDateTime releaseTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "完成时间", name = "completeTime")
    private LocalDateTime completeTime;

    @ApiModelProperty(value = "任务内容", name = "content")
    private String content;

    @ApiModelProperty(value = "负责人(t_user)", name = "principalId")
    private Long principalId;

    @ApiModelProperty(value = "职责", name = "position")
    private String position;

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

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String eventName;

    @ApiModelProperty(value = "负责人", name = "principalName")
    private String principalName;

    @ApiModelProperty(value = "负责人电话", name = "principalPhone")
    private String principalPhone;

    @ApiModelProperty(value = "任务类型id（父）", name = "taskTypeParent")
    private Long taskTypeParent;

    @ApiModelProperty(value = "任务类型名称（父）", name = "taskTypeNameParent")
    private String taskTypeNameParent;

    @ApiModelProperty(value = "任务类型名称", name = "taskTypeName")
    private String taskTypeName;

    @ApiModelProperty(value = "状态（1：已下单，2：已签领，3：已完成）", name = "status")
    private Integer status;

    @ApiModelProperty(value = "机构id", name = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "机构名称", name = "orgName")
    private String orgName;

    @ApiModelProperty(value = "救援点名称", name = "pointName")
    private String pointName;

}
