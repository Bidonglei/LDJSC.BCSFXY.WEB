package com.sunmnet.bigdata.web.model.request.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OpinionInfoREQ")
public class OpinionInfoREQ {


    @ApiModelProperty("提交意见位置信息")
    private String opinionLocation;

    @ApiModelProperty("提交意见类型")
    private String opinionType;

    @ApiModelProperty("意见详情")
    private String opinionContent;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("重要程度")
    private String importance;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createPerson;

//    @ApiModelProperty("修改时间")
//    private String modifyTime;
//
//    @ApiModelProperty("修改人")
//    private String modifyPerson;

	@ApiModelProperty("一级菜单编码")
	private String oneMenuCode;//一级菜单编码

	@ApiModelProperty("一级菜单名称")
	private String oneMenu;//一级菜单名称

	@ApiModelProperty("二级菜单编码")
	private String twoMenuCode;//二级菜单编码

	@ApiModelProperty("二级菜单名称")
	private String twoMenu;//二级菜单名称

	@ApiModelProperty("三级菜单编码")
	private String threeMenuCode;//三级菜单编码

	@ApiModelProperty("三级菜单名称")
	private String threeMenu;//三级菜单名称

	@ApiModelProperty("名字")
	private String name;

	@ApiModelProperty("账号")
	private String account;

    public String getOpinionLocation() {
        return opinionLocation;
    }

    public void setOpinionLocation(String opinionLocation) {
        this.opinionLocation = opinionLocation;
    }

    public String getOpinionType() {
        return opinionType;
    }

    public void setOpinionType(String opinionType) {
        this.opinionType = opinionType;
    }

    public String getOpinionContent() {
        return opinionContent;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

//    public String getModifyTime() {
//        return modifyTime;
//    }
//
//    public void setModifyTime(String modifyTime) {
//        this.modifyTime = modifyTime;
//    }
//
//    public String getModifyPerson() {
//        return modifyPerson;
//    }
//
//    public void setModifyPerson(String modifyPerson) {
//        this.modifyPerson = modifyPerson;
//    }

	public String getOneMenu() {
		return oneMenu;
	}

	public void setOneMenu(String oneMenu) {
		this.oneMenu = oneMenu;
	}

	public String getTwoMenu() {
		return twoMenu;
	}

	public void setTwoMenu(String twoMenu) {
		this.twoMenu = twoMenu;
	}

	public String getThreeMenu() {
		return threeMenu;
	}

	public void setThreeMenu(String threeMenu) {
		this.threeMenu = threeMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOneMenuCode() {
		return oneMenuCode;
	}

	public void setOneMenuCode(String oneMenuCode) {
		this.oneMenuCode = oneMenuCode;
	}

	public String getTwoMenuCode() {
		return twoMenuCode;
	}

	public void setTwoMenuCode(String twoMenuCode) {
		this.twoMenuCode = twoMenuCode;
	}

	public String getThreeMenuCode() {
		return threeMenuCode;
	}

	public void setThreeMenuCode(String threeMenuCode) {
		this.threeMenuCode = threeMenuCode;
	}
}
