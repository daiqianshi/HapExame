package hbi.core.order.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.system.dto.BaseDTO;

@Table(name="hap_om_order_lines")
public class HapOmOrderLines extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column
    @GeneratedValue
	private Long lineId;
	
	@Column
	@NotNull
	private Long headerId;
	
	@Column
	@NotNull
	private Long lineNumber;
	
	@Column
	@NotNull
	private Long inventoryItemId;
	
	@Column
	@NotNull
	private Long orderQuantity;
	
	@Column
    @NotEmpty
	private String orderQuantityUom;

	@Column
	@NotNull
	private Long unitSellingPrice;
	
	@Column
    @NotEmpty
	private String description;
	
	@Column
	@NotNull
	private Long companyId;
	
	@Column
	private String addition1;
	
	@Column
	private String addition2;
	
	@Column
	private String addition3;
	
	@Column
	private String addition4;
	
	@Column
	private String addition5;
	
	@Transient
	private Double amount;
	
	@Transient
	private String itemDescription;
	
	@Transient
	private String itemUom;
	
	@Transient
	private String itemCode;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderQuantityUom() {
		return orderQuantityUom;
	}

	public void setOrderQuantityUom(String orderQuantityUom) {
		this.orderQuantityUom = orderQuantityUom;
	}

	public Long getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(Long unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}
	
	public String getAddition1() {
		return addition1;
	}

	public void setAddition1(String addition1) {
		this.addition1 = addition1;
	}

	public String getAddition2() {
		return addition2;
	}

	public void setAddition2(String addition2) {
		this.addition2 = addition2;
	}

	public String getAddition3() {
		return addition3;
	}

	public void setAddition3(String addition3) {
		this.addition3 = addition3;
	}

	public String getAddition4() {
		return addition4;
	}

	public void setAddition4(String addition4) {
		this.addition4 = addition4;
	}

	public String getAddition5() {
		return addition5;
	}

	public void setAddition5(String addition5) {
		this.addition5 = addition5;
	}

	@Override
	public String toString() {
		return "HapOmOrderLines [lineId=" + lineId + ", headerId=" + headerId + ", lineNumber=" + lineNumber
				+ ", inventoryItemId=" + inventoryItemId + ", orderQuantity=" + orderQuantity + ", orderQuantityUom="
				+ orderQuantityUom + ", unitSellingPrice=" + unitSellingPrice + ", description=" + description
				+ ", companyId=" + companyId + ", amount=" + amount + ", itemDescription=" + itemDescription
				+ ", itemUom=" + itemUom + ", itemCode=" + itemCode + "]";
	}

}
