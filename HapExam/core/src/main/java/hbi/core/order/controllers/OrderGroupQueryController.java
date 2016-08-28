package hbi.core.order.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.order.dto.HapArCustomers;
import hbi.core.order.dto.HapInvInventoryItems;
import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOrgCompanys;
import hbi.core.order.service.OrderGroupQueryService;

/*
 * 订单汇总查询controllers
 */
@Controller
public class OrderGroupQueryController extends BaseController{
	
	@Autowired
	private OrderGroupQueryService queryService;
	
	 /**
     * 任务分配查询.
     * 
     * @param customer
     *            分配对象
     * @param page
     *            起始页
     * @param pagesize
     *            分页大小
     * @param request
     *            HttpServletRequest
     * @return ResponseData
     */
	
	/*
	 * 客户lov查询
	 */
    @RequestMapping(value = "/order/groupQuary/customerQuery")
    @ResponseBody
    public ResponseData getCustomers( HapArCustomers customer, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(queryService.getCustomers(requestContext, customer, page, pagesize));
    }
    /*
     * 公司lov查询
     */
    @RequestMapping(value = "/order/groupQuary/companyQuery")
    @ResponseBody
    public ResponseData getCompanys( HapOrgCompanys company, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(queryService.getCompanys(requestContext, company, page, pagesize));
    }
    
    /*
     * 物料lov查询
     */
    @RequestMapping(value = "/order/groupQuary/inventoryItemQuery")
    @ResponseBody
    public ResponseData getInventoryItems( HapInvInventoryItems inventoryItem, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(queryService.getInvInventoryItems(requestContext, inventoryItem, page, pagesize));
    }
    
    /*
     * 查询订单信息
     */
    @RequestMapping(value = "/order/groupQuary/orderHeaderQuery")
    @ResponseBody
    public ResponseData getOrderHeaders( HapOmOrderHeaders orderHeader, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
    	String companyId = request.getParameter("companyId1");
    	if (null != companyId) {
    		orderHeader.setCompanyId(Long.parseLong(companyId));
		}
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(queryService.getOrderHeaders(requestContext, orderHeader, page, pagesize));
    }
    
    /*
     * 修改订单保存
     */
   /* @RequestMapping(value = "/order/orderEdit/update")
    @ResponseBody*/
}
