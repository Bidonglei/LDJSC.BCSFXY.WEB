package com.sunmnet.bigdata.web.service.home.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.OperateLogInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.OperateLogInfoMapper;
import com.sunmnet.bigdata.web.mapper.home.OpinionMapper;
import com.sunmnet.bigdata.web.model.request.home.OperateInfoPageRequest;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.home.UpdateOpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageREQ;
import com.sunmnet.bigdata.web.service.home.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 意见栏
 * <p>Title: OpinionServiceImpl</p>
 * @author linjianlin
 * @date 2018年9月7日
 */
@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private OpinionMapper opinionMapper;
	@Autowired
	private OperateLogInfoMapper operateLogInfoMapper;
    /**
     *
     * <p>Title: listOpinionInfo</p>
     * @return
     */
    @Override
    public PageInfo listOpinionInfo(OperateInfoPageRequest operateInfoPageRequest)
    {
		PageHelper.startPage(operateInfoPageRequest.getPageNum(), operateInfoPageRequest.getPageSize());
		List<Map> list = opinionMapper.listOpinionInfo(operateInfoPageRequest);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
    }

    @Override
	@Transactional
    public Integer saveOpinionInfo(OpinionInfoREQ opinionInfoREQ) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//增加反馈意见
		opinionInfoREQ.setStatus("PENDING");
		opinionInfoREQ.setCreateTime(df.format(new Date()));
		opinionMapper.saveOpinionInfo(opinionInfoREQ);
		//增加操作日志信息记录
		OperateLogInfo operateLogInfo = new OperateLogInfo();
		operateLogInfo.setName(opinionInfoREQ.getName());
		operateLogInfo.setAccount(opinionInfoREQ.getAccount());
		operateLogInfo.setType("提交反馈");
		operateLogInfo.setOperateTime(df.format(new Date()));
		operateLogInfo.setOperateDescribe("提交反馈意见");
		int i = operateLogInfoMapper.insert(operateLogInfo);
        return i;
    }

	@Override
	public Integer updateOpinionInfoById(UpdateOpinionInfoREQ updateOpinionInfoREQ) {
		return opinionMapper.updateOpinionInfoById(updateOpinionInfoREQ);
	}
}
