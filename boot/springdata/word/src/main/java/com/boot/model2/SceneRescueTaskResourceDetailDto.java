package com.boot.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 现场救援任务-资源 Dto
 * @author: zhanglei
 * @date: 2020-08-21 16:34:18
 */
@Data
@ApiModel(value = "SceneRescueTaskResourceDetailDto", description = "现场救援任务-资源")
public class SceneRescueTaskResourceDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "现场任务id（t_scene_rescue_task）", name = "taskId")
    private Long taskId;

    @ApiModelProperty(value = "对应的资源ID", name = "resourceId")
    private Long resourceId;

    @ApiModelProperty(value = "需要多少数量", name = "needs")
    private Integer needs;

    @ApiModelProperty(value = "1 应急物资 2应急设备 3交通工具", name = "type")
    private Integer type;

    @ApiModelProperty(value = "状态（1：删除，0：正常）", name = "isdeleted")
    private Boolean isdeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "是否加急（1：否，2：是）", name = "urgent")
    private Integer urgent;

}
