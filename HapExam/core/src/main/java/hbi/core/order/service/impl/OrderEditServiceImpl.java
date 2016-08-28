package hbi.core.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hbi.core.order.dto.HapInvInventoryItems;
import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOmOrderLines;
import hbi.core.order.mapper.HapInvInventoryItemMapper;
import hbi.core.order.mapper.HapOrderHeaderMapper;
import hbi.core.order.mapper.HapOrderLineMapper;
import hbi.core.order.service.OrderEditService;

@Service
public class OrderEditServiceImpl extends BaseServiceImpl<HapOmOrderHeaders> implements OrderEditService {
	
	@Autowired
	private HapOrderHeaderMapper headerMapper;
	
	@Autowired
	private HapOrderLineMapper lineMapper;
	
	@Autowired
	private HapInvInventoryItemMapper itemMapper;
	
	
	public List<HapOmOrderHeaders> getByHeaderId(IRequest requestContext,HapOmOrderHeaders header){
		return headerMapper.selectByHeaderId(header);
	}


	@Override
	public List<HapOmOrderLines> getOrderLines(IRequest requestContext, HapOmOrderLines orderLine, int page,
			int pagesize) {
		PageHelper.startPage(page, pagesize);
		return lineMapper.getByLineId(orderLine);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public HapOmOrderHeaders insertOrderHeader(IRequest requestContext, HapOmOrderHeaders headers) {
			headerMapper.insertOrderHeader(headers);
		return headers;
	}
	
	/*@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<HapOmOrderHeaders> batchUpdate(IRequest requestContext, @StdWho List<HapOmOrderHeaders> heards){
		for (int i = 0; i < heards.size(); i++) {
			
		}
	}*/


	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public HapOmOrderHeaders updateOrderHeader(IRequest requestContext, HapOmOrderHeaders header) {
		headerMapper.updateOrderHeader(header);
		return header;
	}


	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<HapOmOrderLines> batchLinesUpdate(IRequest requestContext, List<HapOmOrderLines> lines) {
		for (HapOmOrderLines line : lines) {
			line.setOrderQuantityUom(getItem(line.getInventoryItemId()).getItemCode());
			 if (line.get__status() != null) {
	                switch (line.get__status()) {
	                case DTOStatus.ADD:	
	                	lineMapper.insertOrderLine(line);
	                    break;
	                case DTOStatus.UPDATE:  	
	                	lineMapper.updateOrderLine(line);
	                    break;
	                default:
	                    break;
	                }
	            }
		}
		return lines;
	}
	
	public HapInvInventoryItems getItem(Long inventoryItemId) {
		HapInvInventoryItems item = new HapInvInventoryItems();
		item.setInventoryItemId(inventoryItemId);
		HapInvInventoryItems item1 = itemMapper.selectByInventory(item).get(0);
		return item1;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteOrder(IRequest requestContext, HapOmOrderHeaders orderHeader) {
		int result = 0;
		HapOmOrderLines orderLine = new HapOmOrderLines();
		orderLine.setHeaderId(orderHeader.getHeaderId());	
		List<HapOmOrderLines> lines = lineMapper.getByLineId(orderLine);
		
		result = 1;
		for (HapOmOrderLines hapOmOrderLines : lines) {
			lineMapper.deleteLine(hapOmOrderLines);
			result ++;
		}
		headerMapper.delete(orderHeader);
		return result;
	}

}
