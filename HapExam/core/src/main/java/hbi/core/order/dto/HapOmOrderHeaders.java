package hbi.core.order.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.core.annotation.Children;
import com.hand.hap.system.dto.BaseDTO;

@Table(name = "hap_om_order_headers")
public class HapOmOrderHeaders extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column
    @GeneratedValue
	private Long headerId;
	

    @Column
    @NotEmpty
	private String orderNumber;
	

    @Column
    @NotNull
	private Long companyId;
	

    @Column
    @NotNull
	private Date orderDate;
	

    @Column
    @NotEmpty
	private String orderStatus;
	

    @Column
    @NotNull
	private Long customerId;
    
    @Transient
    private Long inventoryItemId;
    
    @Transient
    private Double amount;
    
    @Transient
    private String companyName;
    
    @Transient
    private String customerName;
    
    @Children
    @Transient
    private List<HapOmOrderLines> orderLines;
    
	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<HapOmOrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<HapOmOrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "HapOmOrderHeaders [headerId=" + headerId + ", orderNumber=" + orderNumber + ", companyId=" + companyId
				+ ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", customerId=" + customerId
				+ ", inventoryItemId=" + inventoryItemId + ", amount=" + amount + ", companyName=" + companyName
				+ ", customerName=" + customerName + ", orderLines=" + orderLines + "]";
	}
	
	
	
}
