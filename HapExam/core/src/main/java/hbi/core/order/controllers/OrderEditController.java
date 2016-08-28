package hbi.core.order.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hbi.core.order.dto.HapInvInventoryItems;
import hbi.core.order.dto.HapOmOrderHeaders;
import hbi.core.order.dto.HapOmOrderLines;
import hbi.core.order.service.OrderEditService;

@Controller
public class OrderEditController extends BaseController{
	
	@Autowired
	private OrderEditService orderEditService;
	
	 @RequestMapping(value = "/order/edit/orderHeaderQuery")
	    @ResponseBody
	    public ResponseData getOrderHeaders( HapOmOrderHeaders orderHeader, HttpServletRequest request) {
	        IRequest requestContext = createRequestContext(request);
	        List<HapOmOrderHeaders> orderHeader1 = orderEditService.getByHeaderId(requestContext, orderHeader);
	        for (HapOmOrderHeaders hapOmOrderHeaders : orderHeader1) {
				System.out.println(hapOmOrderHeaders);
			}
	        return new ResponseData(orderHeader1);
	    }
	 
	
	 @RequestMapping(value = "/order/edit/orderLinesQuery")
	 @ResponseBody
	 public ResponseData getOrderLines( HapOmOrderLines orderLines, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
	            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
	    	
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(orderEditService.getOrderLines(requestContext, orderLines, page, pagesize));
	    }  
	 
	 
	
	    @RequestMapping(value="/order/edite/createHeader")
	    @ResponseBody
	   public ResponseData saveOrderHeader( @RequestBody HapOmOrderHeaders orderHeader,BindingResult result, HttpServletRequest request) throws BaseException {
	        //没意义的值
		 
		 if (null == orderHeader.getOrderStatus()) {
			orderHeader.setOrderStatus("新建");
		}
		 orderHeader.setObjectVersionNumber(0L);
	        
	        getValidator().validate(orderHeader, result);
	        if (result.hasErrors()) {
	            ResponseData responseData = new ResponseData(false);
	            responseData.setMessage(getErrorMessage(result, request));
	            return responseData;
	        }
	        IRequest requestContext = createRequestContext(request);
	       orderEditService.insertOrderHeader(requestContext, orderHeader);
	        return new ResponseData();
	    }
	    
	    @RequestMapping(value = "/order/edite/headerUpdate", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData updateOrderHeader(HttpServletRequest request, @RequestBody HapOmOrderHeaders header, BindingResult result) throws BaseException {
	    	//没意义的值
	    	header.setObjectVersionNumber(0L);
	        
	        getValidator().validate(header, result);
	        if (result.hasErrors()) {
	            ResponseData responseData = new ResponseData(false);
	            responseData.setMessage(getErrorMessage(result, request));
	            return responseData;
	        }
	        IRequest requestContext = createRequestContext(request);
	        orderEditService.updateOrderHeader(requestContext, header);
	        return new ResponseData();
	    }
	    
	    @RequestMapping(value = "/order/edite/linesUpdate", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData lineUpdate(@RequestBody List<HapOmOrderLines> lines, BindingResult result, HttpServletRequest request)
	            throws BaseException {
	    	String headerId = request.getParameter("headerId");
	    	for (HapOmOrderLines hapOmOrderLines : lines) {
	    		hapOmOrderLines.setHeaderId(Long.parseLong(headerId));
	    		hapOmOrderLines.setOrderQuantityUom("默认");
				System.out.println(hapOmOrderLines);
				 getValidator().validate(hapOmOrderLines, result);
				 if (result.hasErrors()) {
			            ResponseData rd = new ResponseData(false);
			            rd.setMessage(getErrorMessage(result, request));
			            return rd;
			        }
			}
	    	/*
	        getValidator().validate(lines, result);
	        if (result.hasErrors()) {
	            ResponseData rd = new ResponseData(false);
	            rd.setMessage(getErrorMessage(result, request));
	            return rd;
	        }*/
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(orderEditService.batchLinesUpdate(requestContext, lines));
	    }
	    
	    
	    @RequestMapping(value = "/order/edite/deleteOrder", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData deleteResource(HttpServletRequest request, @RequestBody HapOmOrderHeaders orderHeader)
	            throws BaseException {	    	
	        IRequest requestContext = createRequestContext(request);
	        orderEditService.deleteOrder(requestContext, orderHeader);
	        return new ResponseData();
	    }
	    
	   
	    
	    @RequestMapping(value = "/order/edite/setStatus", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseData updateOrderStatus(HttpServletRequest request, @RequestBody HapOmOrderHeaders header, BindingResult result) throws BaseException {
	       
	    	String orderStatus = request.getParameter("orderStatus1");
	    	header.setOrderStatus(orderStatus);
	    	System.out.println(header);
	    	//没意义的值
	    	header.setObjectVersionNumber(0L);
	        
	        getValidator().validate(header, result);
	        if (result.hasErrors()) {
	            ResponseData responseData = new ResponseData(false);
	            responseData.setMessage(getErrorMessage(result, request));
	            return responseData;
	        }
	        IRequest requestContext = createRequestContext(request);
	        orderEditService.updateOrderHeader(requestContext, header);
	        return new ResponseData();
	    }

}
