package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 现场救援任务-救援队 Dto
 * @author: zhanglei
 * @date: 2020-08-21 16:34:19
 */
@Data
@ApiModel(value = "SceneRescueTaskTeamDetailDto", description = "现场救援任务-救援队")
public class SceneRescueTaskTeamDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "现场任务id（t_scene_rescue_task）", name = "taskId")
    private Long taskId;

    @ApiModelProperty(value = "救援队伍id(t_rescue_team)", name = "rescueTeamId")
    private Long rescueTeamId;

    @ApiModelProperty(value = "负责人", name = "principal")
    private String principal;

    @ApiModelProperty(value = "负责人电话", name = "phone")
    private String phone;

    @ApiModelProperty(value = "队伍职责", name = "position")
    private String position;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "状态（1：删除，0：正常）", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

}
