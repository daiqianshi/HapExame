package hbi.core.order.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.order.dto.HapOmOrderHeaders;

public interface HapOrderHeaderMapper extends Mapper<HapOmOrderHeaders>{
	
	public List<HapOmOrderHeaders> selectByOrderHeader(HapOmOrderHeaders orderHeader);
	
	public List<HapOmOrderHeaders> selectByHeaderId(HapOmOrderHeaders orderHeader);
	
	public int insertOrderHeader(HapOmOrderHeaders orderHeader);

	public int updateOrderHeader(HapOmOrderHeaders header);
	
}
