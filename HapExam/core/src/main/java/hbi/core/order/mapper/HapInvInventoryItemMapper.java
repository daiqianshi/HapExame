package hbi.core.order.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.order.dto.HapInvInventoryItems;

public interface HapInvInventoryItemMapper extends Mapper<HapInvInventoryItems>{
	
	public List<HapInvInventoryItems> selectByInventory(HapInvInventoryItems inventoryItem);
}
