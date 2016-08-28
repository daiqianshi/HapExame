package hbi.core.order.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOmOrderLines;

public interface OrderEditService extends IBaseService<HapOmOrderHeaders>,ProxySelf<HapOmOrderHeaders>{
	
	public List<HapOmOrderHeaders> getByHeaderId(IRequest requestContext,HapOmOrderHeaders header);
	
	public List<HapOmOrderLines> getOrderLines(IRequest requestContext, HapOmOrderLines orderLine, int page, int pagesize);
	
	public HapOmOrderHeaders insertOrderHeader(IRequest requestContext,@StdWho HapOmOrderHeaders headers);
	
	public List<HapOmOrderLines> batchLinesUpdate(IRequest requestContext, @StdWho List<HapOmOrderLines> lines);

	public HapOmOrderHeaders updateOrderHeader(IRequest requestContext, @StdWho HapOmOrderHeaders header);

	public int deleteOrder(IRequest requestContext, HapOmOrderHeaders orderHeader);
    
	
}
