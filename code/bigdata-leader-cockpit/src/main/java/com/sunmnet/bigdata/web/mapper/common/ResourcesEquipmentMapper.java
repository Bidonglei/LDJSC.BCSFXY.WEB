/**
 * ResourcesEquipmentMapper.java
 * 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.common;

import com.sunmnet.bigdata.web.model.entity.common.ResourcesEquipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourcesEquipmentMapper {
    /**
     * 
     * @mbg.generated 2018-08-27
     */
    List<ResourcesEquipment> listAll();

    /**
     * 科研资源：本科校内实验、实训场所及设备
     * @param year
     * @return
     */
    List<ResourcesEquipment> listEquipmentByYear(@Param("year") String year);

    /**
     * 科研资源：本科校内实验、实训场所及设备
     * @param years
     * @return
     */
    List<ResourcesEquipment> listEquipmentByYears(@Param("years") String[] years);
}