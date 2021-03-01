package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 视频会商 Dto
 * @author: lijiayu
 * @date: 2020-06-08 14:39:09
 */
@Data
@ApiModel(value = "MeetVideoListDto", description = "视频会商")
public class MeetVideoListDto {

    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "事件id", name = "eventId")
    private Integer eventId;

    @ApiModelProperty(value = "亿联会议ID", name = "meetId")
    private String meetId;

    @ApiModelProperty(value = "亿联会议分组ID", name = "categoryId")
    private String categoryId;

    @ApiModelProperty(value = "会议名称", name = "meetName")
    private String meetName;

    @ApiModelProperty(value = "会议类型 1.视频会议2.音频会议", name = "meetType")
    private Integer meetType;

    @ApiModelProperty(value = "会议模式 1.default（讨论模式）2.demonstrator（主席模式）", name = "meetMode")
    private Integer meetMode;

    @ApiModelProperty(value = "会议状态", name = "meetStauts")
    private Integer meetStauts;

    @ApiModelProperty(value = "会议持续时间,单位秒", name = "meetDuration")
    private Integer meetDuration;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间", name = "startTime")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "会议号码", name = "meetNumber")
    private String meetNumber;

    @ApiModelProperty(value = "会议密码", name = "meetPassword")
    private String meetPassword;

    @ApiModelProperty(value = "会议组织者名称 - 创建人名称", name = "meetOwnerName")
    private String meetOwnerName;

    @ApiModelProperty(value = "会议主持名称", name = "meetHostName")
    private String meetHostName;

    @ApiModelProperty(value = "会议主持", name = "meetHost")
    private String meetHost;

    @ApiModelProperty(value = "是否禁言", name = "autoMuteEnable")
    private Integer autoMuteEnable;

    @ApiModelProperty(value = "会议人员", name = "meetParticipater")
    private String meetParticipater;

    @ApiModelProperty(value = "会议人员Name", name = "meetParticipaterName")
    private String meetParticipaterName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "会议室链接", name = "joinUrl")
    private String joinUrl;

}
