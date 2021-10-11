package com.sunmnet.bigdata.systemManage.base.systemManage.entity;

import com.sunmnet.bigdata.systemManage.base.support.entity.BaseEntity;


/**
 * @ClassName SunmnetAcademyInfoEntity
 * @Description 学院信息表
 * @author wm
 * @date 2018-04-20 21:32:48
 * @version 1.0 
 */
public class SunmnetAcademyInfoEntity  extends BaseEntity{

	private static final long serialVersionUID = -5339774358566405633L;
	//主键自增
    private Long id;
    //学院代码
    private String code;
    //学院名称
    private String name;
    //学院类型
    private Short type;
    //校区代码
    private String collegeCode;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Short getType() {
        return type;
    }
    public void setType(Short type) {
        this.type = type;
    }
    public String getCollegeCode() {
        return collegeCode;
    }
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode == null ? null : collegeCode.trim();
    }

}