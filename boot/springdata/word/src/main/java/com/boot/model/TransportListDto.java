package com.boot.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @description 应急救援交通运输分页查询实体
 * @author lilianghuai
 * @date 2020年4月27日下午4:32:28
 */
@Data
@ApiModel(value = "TransportListDto", description = "应急救援交通运输")
public class TransportListDto {

	@ApiModelProperty(value = "ID", name = "id")
    private Long id;

    @ApiModelProperty(value = "设备唯一标识", name = "code")
    private String code;

    @ApiModelProperty(value = "交通运输类型名称", name = "categoryName")
    private String categoryName;

    @ApiModelProperty(value = "名称", name = "trafficName")
    private String trafficName;

    @ApiModelProperty(value = "负责人", name = "managerName")
    private String managerName;

    @ApiModelProperty(value = "应急手机", name = "emergencyPhone")
    private String emergencyPhone;

    @ApiModelProperty(value = "管理组织名称", name = "adminOrgName")
    private String adminOrgName;

    @ApiModelProperty(value = "状态 1:正常 2:报废", name = "status")
    private Integer status;

    @ApiModelProperty(value = "数量", name = "num")
    private  Integer num;

    @ApiModelProperty(value = "计量单位", name = "num")
    private  String unit;
}
