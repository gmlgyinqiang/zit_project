package com.edgedo.sys.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.queryvo.ScaleUserOrderQuery;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ScaleUserOrderMapper  extends BaseMapper<ScaleUserOrder>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserOrderView> listPage(ScaleUserOrderQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserOrderView> listByObj(ScaleUserOrderQuery query);

	public List<ScaleUserOrderView> selectByScaleIdAndCompanyId(Map<String,Object> param);

	public int logicDelete(String id);

    BigDecimal getAllPrice();

	Integer getWfkCount();

	Integer getCpzCount();

	Integer getYwcCount();

	Integer getYzfCount();

    List<ScaleUserOrder> getAllEndOrder();

	List<ScaleUserOrder> getAllForthEndOrder();

	int updateOrderState(@Param("ownerOrderId") String ownerOrderId,@Param("state") String state);

    int countByCompOrderId(String id);

	List<ScaleUserOrderView> listPageOrder(ScaleUserOrderQuery query);

    BigDecimal sumPriceByMonth(ScaleUserOrderQuery query);

	public ScaleUserOrder selectByDate(ScaleUserOrder view);
}