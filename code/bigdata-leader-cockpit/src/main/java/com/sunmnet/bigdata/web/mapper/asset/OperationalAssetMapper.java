/**
* SStudentInfoMapper.java
* 三盟科技
*
*/
package com.sunmnet.bigdata.web.mapper.asset;

import com.sunmnet.bigdata.web.model.request.personnel.ForeignInvestmentREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OperationalAssetMapper {

	/**
	 *功能描述 通过工商注册号获取详细信息
	 * @author lkg
	 * @date 2019/2/21
	 */
	Map<String, String> ownershipStructure(@Param("registrationNum") String registrationNum);
	/**
	 *功能描述 对外经营性公司结构
	 * @author lkg
	 * @date 2019/2/21
	 */
	List<Map> listCompanyStructure();
	/**
	 *功能描述 对外投资公司列表
	 * @author lkg
	 * @date 2019/2/22
	 */
	List<Map> listForeignInvestment(ForeignInvestmentREQ foreignInvestmentREQ);
}