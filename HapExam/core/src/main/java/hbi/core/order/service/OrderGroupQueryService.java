package hbi.core.order.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hbi.core.order.dto.HapArCustomers;
import hbi.core.order.dto.HapInvInventoryItems;
import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOrgCompanys;

public interface OrderGroupQueryService extends IBaseService<HapOmOrderHeaders>, ProxySelf<OrderGroupQueryService>{
	
	public List<HapArCustomers> getCustomers(IRequest requestContext, HapArCustomers customer, int page, int pagesize);
	public List<HapOrgCompanys> getCompanys(IRequest requestContext, HapOrgCompanys company, int page, int pagesize);
	public List<HapInvInventoryItems> getInvInventoryItems(IRequest requestContext, HapInvInventoryItems inventoryItem, int page, int pagesize);
	
	public List<HapOmOrderHeaders> getOrderHeaders(IRequest requestContext, HapOmOrderHeaders orderHeader, int page, int pagesize);
}
