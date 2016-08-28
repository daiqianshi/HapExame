package hbi.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hbi.core.order.dto.HapArCustomers;
import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOrgCompanys;
import hbi.core.order.dto.HapInvInventoryItems;
import hbi.core.order.mapper.HapArCustomerMapper;
import hbi.core.order.mapper.HapInvInventoryItemMapper;
import hbi.core.order.mapper.HapOrderHeaderMapper;
import hbi.core.order.mapper.HapOrgCompanyMapper;
//import hbi.core.order.mapper.OrderGroupQueryMapper;
import hbi.core.order.service.OrderGroupQueryService;

@Service
public class OrderGroupQueryServiceImpl extends BaseServiceImpl<HapOmOrderHeaders> implements OrderGroupQueryService {
	
	/*@Autowired
	private OrderGroupQueryMapper queryMapper;*/
	
	@Autowired
	private HapArCustomerMapper customerMapper;
	
	@Autowired
	private HapOrgCompanyMapper companyMapper;
	
	@Autowired
	private HapInvInventoryItemMapper inventtoryMapper;
	
	@Autowired
	private HapOrderHeaderMapper orderHeaderMapper;

	@Override
	public List<HapArCustomers> getCustomers(IRequest requestContext, HapArCustomers customer, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return customerMapper.selectByCustomer(customer);
	}

	@Override
	public List<HapOrgCompanys> getCompanys(IRequest requestContext, HapOrgCompanys company, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return companyMapper.selectByCompany(company);
	}

	@Override
	public List<HapInvInventoryItems> getInvInventoryItems(IRequest requestContext,
			HapInvInventoryItems inventoryItem, int page, int pagesize) {
		PageHelper.startPage(page, pagesize);
		return inventtoryMapper.selectByInventory(inventoryItem);
	}

	@Override
	public List<HapOmOrderHeaders> getOrderHeaders(IRequest requestContext, HapOmOrderHeaders orderHeader, int page,
			int pagesize) {
		PageHelper.startPage(page, pagesize);
		return orderHeaderMapper.selectByOrderHeader(orderHeader);
	}
	
	

}
