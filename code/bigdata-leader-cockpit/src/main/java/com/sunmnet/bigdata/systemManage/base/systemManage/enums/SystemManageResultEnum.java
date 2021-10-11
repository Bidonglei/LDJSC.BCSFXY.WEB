package com.sunmnet.bigdata.systemManage.base.systemManage.enums;

/**
 * @Description: 系统返回结果，对外输出结果 系统版本号04
 * 1-2 系统版本
 * 3-4 模块
 * 5-6 具体业务
 * @author wm
 * @date 2018-01-23
 */
public enum SystemManageResultEnum {

	//----------------系统公共00 ------------------
	
	//----------------用户01 ------------------
	NO_USER("040101", "无此用户"),
	ERROR_PASSWORD("040102","密码错误"),
	MOBILE_EXISTENCE("040104","手机号已存在"),
	ROLEINFO_EXISTENCE("040105","用户存在角色,请回收后操作"),
	RELATION_EXISTENCE("040106","教工号/学号已存在，请确认"),
	PASSWORD_ERROR_OLD("040107","旧密码不正确,请核实"),
	STUDENT_INFO_IS_NULL("040108","同步学生信息集合不能为空"),
	TEACHER_INFO_IS_NULL("040109","同步教职工信息集合不能为空"),
	USERNO_IS_NULL("040110","用户编号集合不能为空"),
	USER_LOCK("040111", "用户已经被锁定"),
	//----------------系统02 ------------------
	SYSTEM_NO_EXIST("040201","系统编号已存在"),
	NO_SYSTEM_NO("040202","系统信息不存在"),
	NO_SYSTEM("040203","系统编号不存在"),
	SYSTEM_HAVE_MENU("040204","系统下有菜单,请回收后操作"),
	SYSTEM_HAVE_DEPARTMNET("040205","系统下有部门,请回收后操作"),
	SYSTEM_HAVE_USER("040206","系统下有用户,请回收后操作"),
	SYSTEM_FILE_IS_NULL("040207","上传的系统风格图片为空"),
	IMG_NOT_EXISTS("040208","图片不存在"),
	//----------------管理员03 ------------------
	NO_SYSTEM_AMDIN("040301","管理员不存在"),
	AMDIN_HAVE_MENU("040302","管理员存在授权菜单,请回收后操作"),
	STATUS_NOT_NORMAL("040303","管理员状态不是正常状态，请核实"),
	OLD_PASSWORD_ERROR("040304","原始密码错误，请核实"),
	//----------------部门04 ------------------
	NO_DEPARTMENT("040401","无此部门"),
	DEPARTMENT_HAVA_USER("040402","部门下存在用户"),
	DEPARTMENTNAME_EXISTENCE("040403","部门名称已存在"),
	
	//----------------角色05 ------------------
	NO_ROLE("040501","角色不存在"),
	ROLE_SET_USER("040502","角色已经授权给用户,请回收后操作"),
	
	
	//----------------菜单06 ------------------
	MENU_NO_EXIST("040601","菜单编号已存在"),
	NO_MENU("040602","菜单不存在"),
	MENU_SET_ROLE_OR_FUNTION_SET_ROLE("040603","菜单或功能点已授权给角色,请回收后操作"),
	FUNTION_EXIST("040604","功能点编号已存在"),
	NO_FUNTION("040605","功能点不存在"),
	CREATE_MENU_NO_FAIL("040606","生成菜单编号失败"),
	NO_THIS_MENU_TYPE("040607","不支持的菜单类型"),
	TWO_MENU_NO_ONE_MENU("040608","二级菜单必须有一级菜单编号"),
	THREE_MENU_NO_TWO_MENU("040611","三级级菜单必须有二级菜单编号"),
	ONE_FUNTION_NO_FIRST_MENO_NO("040609","一级菜单添加功能点必须要有一级菜单编号"),
	TWO_FUNTION_NO_FIRST_MENO_NO("040610","二级菜单添加功能点必须要有一级菜单编号"),
	TWO_FUNTION_NO_SECOND_MENO_NO("040611","二级菜单添加功能点必须要有二级菜单编号"),
	MENU_HAVE_CHILD_MENU("040612","该菜单有子菜单或者子功能点"),
	//----------------字典07 ------------------
	NO_DICTTYPE("040701","字典标识不存在"),
	DICTTYPE_EXIST("040702","字典标识已存在"),
	DICTIONARIES_KEY_EXIST("040703", "字典Key值不能重复")
	;

	private String code;
    private String message;
    
    private SystemManageResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
   
}
