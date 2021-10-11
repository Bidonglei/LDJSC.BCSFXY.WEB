package com.sunmnet.bigdata.web.service.asset.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.web.mapper.asset.OperationalAssetMapper;
import com.sunmnet.bigdata.web.model.request.personnel.ForeignInvestmentREQ;
import com.sunmnet.bigdata.web.service.asset.OperationalAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 资产
 * <p>Title: StudentInfoService</p>
 * @author
 * @date
 */
@Service
public class OperationalAssetServiceImpl implements OperationalAssetService {

    @Autowired
	private OperationalAssetMapper operationalAssetMapper;


	@Override
	public Map<String, String> ownershipStructure(String registrationNum) {
		return operationalAssetMapper.ownershipStructure(registrationNum);
	}

	@Override
	public List<Map> listCompanyStructure() {
		return operationalAssetMapper.listCompanyStructure();
	}

	@Override
	public PageInfo<Map> pageForeignInvestment(ForeignInvestmentREQ foreignInvestmentREQ, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Map> list = operationalAssetMapper.listForeignInvestment(foreignInvestmentREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
