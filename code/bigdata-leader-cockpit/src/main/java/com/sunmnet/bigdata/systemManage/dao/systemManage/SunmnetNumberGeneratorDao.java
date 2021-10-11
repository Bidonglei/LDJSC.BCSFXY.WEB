package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetNumberGeneratorEntity;

public interface SunmnetNumberGeneratorDao {



	 /**
     * 修改编号加1
     * @author wm
     * @create 2018-05-20
     * @return
     */
    public int updateNumberGenerator(SunmnetNumberGeneratorEntity record);

    /**
     * 获取菜单编号信息
     * @author wm
     * @create 2018-05-20
     * @return
     */
	public SunmnetNumberGeneratorEntity getNumberGenerator();

}