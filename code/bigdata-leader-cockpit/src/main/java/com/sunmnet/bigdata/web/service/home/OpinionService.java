package com.sunmnet.bigdata.web.service.home;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.response.PageResult;
import com.sunmnet.bigdata.web.model.request.home.OperateInfoPageRequest;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.home.UpdateOpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageREQ;

/**
 * 意见栏
 * <p>Title: OpinionService</p>
 * @author linjianlin
 * @date 2018年9月7日
 */
public interface OpinionService {

    /**
     * 意见栏列表展示
     * <p>Title: listOpinionInfo</p>
     * @return
     */
	PageInfo listOpinionInfo(OperateInfoPageRequest operateInfoPageRequest);

    /**
     * 意见栏列表增加
     * <p>Title: saveOpinionInfo</p>
     * @return
     */
    Integer saveOpinionInfo(OpinionInfoREQ opinionInfoREQ);
	/**
	 *功能描述 修改反馈意见
	 * @author lkg
	 * @date 2019/8/21
	 */
	Integer updateOpinionInfoById(UpdateOpinionInfoREQ updateOpinionInfoREQ);
}
