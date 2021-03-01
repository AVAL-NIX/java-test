package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 现场救援任务-人员 Dto
 * @author: zhanglei
 * @date: 2020-08-21 16:34:19
 */
@Data
@ApiModel(value = "SceneRescueTaskMemberDetailDto", description = "现场救援任务-人员")
public class SceneRescueTaskMemberDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "现场任务id（t_scene_rescue_task）", name = "taskId")
    private Long taskId;

    @ApiModelProperty(value = "成员id", name = "userId")
    private Long userId;

    @ApiModelProperty(value = "成员的机构id", name = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "内容", name = "content")
    private String content;

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
