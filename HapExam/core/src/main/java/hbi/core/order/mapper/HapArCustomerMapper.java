package hbi.core.order.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.order.dto.HapArCustomers;

public interface HapArCustomerMapper extends Mapper<HapArCustomers> {
	
	public List<HapArCustomers> selectByCustomer(HapArCustomers customer);
}
