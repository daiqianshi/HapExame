package hbi.core.order.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.order.dto.HapOmOrderLines;

public interface HapOrderLineMapper extends Mapper<HapOmOrderLines>{
	
	public List<HapOmOrderLines> getByLineId(HapOmOrderLines orderLine);

	public int insertOrderLine(HapOmOrderLines line);

	public int updateOrderLine(HapOmOrderLines line);

	public int deleteLine(HapOmOrderLines hapOmOrderLines);
	
	
}
