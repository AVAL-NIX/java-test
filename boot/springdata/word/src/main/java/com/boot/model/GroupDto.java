package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @description:
 * @author: lijiayu
 * @date: 2020-03-30 16:09
 **/
@Data
@ApiModel(value = "GroupDto", description = "组查询响应参数")
public class GroupDto {

    private Long id;
    private String name;

    @ApiModelProperty(value = "群组类型 0-默认 2-预设群组 3-临时", name = "type")
    private Integer type;
    private String types;

    @ApiModelProperty(value = "群组类型", name = "typeText")
    private String typeText;

    @ApiModelProperty(value = "启用状态 0-未启用 1-启用", name = "enabledStatus")
    private Integer enabledStatus;

    @ApiModelProperty(value = "预设人数", name = "presetMemberNum")
    private Integer presetMemberNum;

    @ApiModelProperty(value = "当前人数", name = "currentMemberNum")
    private Integer currentMemberNum;
    private Integer memberIndex = 0;
    private Integer onlineCount = 0;
    private Long createId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updatedAt;

    @ApiModelProperty(value = "消息对讲模式：0-语音消息，1-实时对讲", name = "msgModel")
    private Integer msgModel;

    private String invalidTimeString;
    private String enableTimeString;
    private String disableTimeString;

    private Float validTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date invalidTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date enableTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date disableTime;
    private String description;
    private String contact;
    private String contactPhone;
    private Long manager;
    private Integer isDeleted;

    private String departIds;
    private Long departId;
    private String userIds;
    private String nickName;
    private String userName;
    private String serialNumber;
    private Integer userAdmin;
    private String departName;



}
