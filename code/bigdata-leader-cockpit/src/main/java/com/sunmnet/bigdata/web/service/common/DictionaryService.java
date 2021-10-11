package com.sunmnet.bigdata.web.service.common;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

	List<String> getDictList(String dictType);
	/**
	 * @Description 总搜索框接口
	 * @author linjl
	 * @date 2019/2/21
	 */
	Map<String,List<Map<String,String>>> listSearchBox();
}
