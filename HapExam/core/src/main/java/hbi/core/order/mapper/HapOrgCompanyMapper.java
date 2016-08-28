package hbi.core.order.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.order.dto.HapOrgCompanys;

public interface HapOrgCompanyMapper extends Mapper<HapOrgCompanys>{
	
	public List<HapOrgCompanys> selectByCompany(HapOrgCompanys company);
}
