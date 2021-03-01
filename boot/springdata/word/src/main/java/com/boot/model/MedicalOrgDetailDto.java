package com.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 应急医疗机构 Dto
 * @author: zhanglei
 * @date: 2020-07-14 10:01:16
 */
@Data
@ApiModel(value = "MedicalOrgDetailDto", description = "应急医疗机构")
public class MedicalOrgDetailDto {

    @ApiModelProperty(value = "", name = "id")
    private Long id;

    @ApiModelProperty(value = "名称", name = "medicalName")
    private String medicalName;

    @ApiModelProperty(value = "类型", name = "medicalCategoryId")
    private Long medicalCategoryId;

    @ApiModelProperty(value = "单位级别，1:一级甲等，2:一级乙等，3:一级丙等，4:二级甲等，5:二级乙等， 6:二级丙等，7:三级特等，8:三级甲等，9:三级乙等，10:三级丙等，11:其他", name = "medicalLevel")
    private Long medicalLevel;

    @ApiModelProperty(value = "级别 1:省级，2:市级，3:县级，4:乡镇级，5:存社，6:其他", name = "level")
    private Long level;

    @ApiModelProperty(value = "密级 1:机密，2:秘密，3:限制，4:公开，5:其他", name = "privateLevel")
    private Long privateLevel;

    @ApiModelProperty(value = "行政区划id", name = "regionId")
    private Long regionId;

    @ApiModelProperty(value = "值班电话", name = "dutyPhone")
    private String dutyPhone;

    @ApiModelProperty(value = "主管单位", name = "manageUnit")
    private Long manageUnit;

    @ApiModelProperty(value = "主管单位地址", name = "manageUnitAddr")
    private String manageUnitAddr;

    @ApiModelProperty(value = "地址", name = "address")
    private String address;

    @ApiModelProperty(value = "邮编", name = "postcode")
    private String postcode;

    @ApiModelProperty(value = "传真", name = "fax")
    private String fax;

    @ApiModelProperty(value = "病床数", name = "sickbedNum")
    private Integer sickbedNum;

    @ApiModelProperty(value = "医生数", name = "doctorNum")
    private Integer doctorNum;

    @ApiModelProperty(value = "护士数", name = "nurseNum")
    private Integer nurseNum;

    @ApiModelProperty(value = "其他卫生技术人员数", name = "otherNum")
    private Integer otherNum;

    @ApiModelProperty(value = "救护车数量", name = "ambulanceNum")
    private Integer ambulanceNum;

    @ApiModelProperty(value = "抗震设防烈度", name = "seismicIntensity")
    private Integer seismicIntensity;

    @ApiModelProperty(value = "经度", name = "longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", name = "latitude")
    private Double latitude;

    @ApiModelProperty(value = "主要特色", name = "trait")
    private String trait;

    @ApiModelProperty(value = "主要医疗装备", name = "medicalDevice")
    private String medicalDevice;

    @ApiModelProperty(value = "应急通讯方式", name = "communicationMode")
    private String communicationMode;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

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

    @ApiModelProperty(value = "类型名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "单位等级名称", name = "medicalLevelName")
    private String medicalLevelName;

    @ApiModelProperty(value = "级别名称", name = "levelName")
    private String levelName;

    @ApiModelProperty(value = "唯一标识", name = "mark")
    private String mark;

    @ApiModelProperty(value = "密级名称", name = "privateLevelName")
    private String privateLevelName;

    @ApiModelProperty(value = "行政区域名称", name = "regionName")
    private String regionName;

    @ApiModelProperty(value = "数据来源机构名称", name = "dataSourceOrgName")
    private String dataSourceOrgName;

    @ApiModelProperty(value = "主管机构名称", name = "manageUnitName")
    private  String manageUnitName;

}
