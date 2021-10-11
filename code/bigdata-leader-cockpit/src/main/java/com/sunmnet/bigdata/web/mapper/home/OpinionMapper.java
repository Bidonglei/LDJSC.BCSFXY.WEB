package com.sunmnet.bigdata.web.mapper.home;

import com.sunmnet.bigdata.web.model.request.home.OperateInfoPageRequest;
import com.sunmnet.bigdata.web.model.request.home.UpdateOpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageREQ;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OpinionMapper {

    /**
     * 意见栏列表展示
     * <p>Title: listOpinionInfo</p>
     * @return
     */
    List<Map> listOpinionInfo(OperateInfoPageRequest operateInfoPageRequest);
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
