/**
 * ResourcesEquipmentFundsMapper.java
 * 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.common;

import com.sunmnet.bigdata.web.model.entity.common.ResourcesEquipmentFunds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourcesEquipmentFundsMapper {
    /**
     * 
     * @mbg.generated 2018-08-27
     */
    List<ResourcesEquipmentFunds> listAll();

    /**
     * 科研资源：教学、科研仪器设备资产
     * @param year
     * @return
     */
    ResourcesEquipmentFunds listEquipmentFundsByYear(@Param("year") String year);

    /**
     * 科研资源：教学、科研仪器设备资产
     * @param years
     * @return
     */
    ResourcesEquipmentFunds listEquipmentFundsByYears(@Param("years") String[] years);
}