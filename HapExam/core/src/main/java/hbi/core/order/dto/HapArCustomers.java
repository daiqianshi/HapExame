package hbi.core.order.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.hand.hap.system.dto.BaseDTO;

@Table(name = "hap_ar_customers")
public class HapArCustomers extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column
    @GeneratedValue
    private  Long customerId;
	

    @Column 
    @NotEmpty
	private String customerNumber;
	

    @Column
    @NotEmpty
	private String customerName;
	

    @Column
    @NotNull
	private Long companyId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
