package com.sunmnet.bigdata.web.mapper.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: lkg
 * @Date: 2019/2/18 17:33
 */
public interface DictionaryMapper {

	List<String> getDictList(@Param(value = "dictType") String dictType);

	/**
	 * @Description 总搜索框接口
	 * @author linjl
	 * @date 2019/2/21
	 */
	List<Map> listSearchBox();
}
