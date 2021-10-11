package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemStyleEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemStyleListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.SystemImgModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemStyleListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadImgStatusRequest;

public interface SunmnetSystemStyleDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemStyleEntity record);

    public SunmnetSystemStyleEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemStyleEntity record);

    /**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	public SunmnetSystemStyleEntity queryEntityByRequest(
			UploadImgStatusRequest uploadImgStatusRequest);

	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public List<QuerySystemStyleListModel> querySystemStyleType(
			QuerySystemStyleListRequest querySystemStyleListRequest);

	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public List<SystemImgModel> querySystemStyleList(
			QuerySystemStyleListRequest querySystemStyleListRequest);
	/**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	public int updateApplyStatus(SunmnetSystemStyleEntity styleEntity);

}