package cn.itcast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.Items;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	/**
	 * 全部商品列表的展示
	 */
	@RequestMapping("/list")
	public String getItemsList(Model model) throws Exception {

		List<Items> itemsList = itemsService.findItemsList();

		model.addAttribute("itemList", itemsList);

		return "items/itemList";
	}

	
	
	
	/**
	 * 测试json数据转化为对象数据
	 * 			1:将@ResponseBody注释再方法上
	 * 			2:将@ResponseBody注释到返回值类型上
	 * @param items
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping("/sendJson")
	@ResponseBody
	public Items sendJson(@RequestBody Items items) throws Exception {
		System.out.println(items);
		items.setDetail("aaaa");
		return items;
	}*/
	
	@RequestMapping("/sendJson")
	public @ResponseBody Items sendJson(@RequestBody Items items) throws Exception {
		System.out.println(items);
		items.setDetail("aaaa");
		return items;
	}
	
	
	
	
	
	
	
	/*
	 * /修改
	 */
	/*@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest  request,Model model)throws Exception {

		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Items itemsResult = itemsService.getItemsDetailById(id);
		
		model.addAttribute("item", itemsResult);
		
		return "items/editItem";
	}*/
	
	@RequestMapping("/itemEdit")
	public ModelAndView itemEdit(HttpServletRequest  request,String id)throws Exception {

		Integer id2 = Integer.valueOf(request.getParameter("id"));
		
		Items itemsResult = itemsService.getItemsDetailById(id2);
		
//		model.addAttribute("item", itemsResult);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", itemsResult);
		modelAndView.setViewName("items/editItem");
		return modelAndView;
	}
	
	
	
	
	
	
	/*
	 * 更新Items items
	 */
	/*@RequestMapping("/updateitem")
	public String updateitem(Integer id, String name, Float price, String detail){
		
		Items items = new Items();
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setDetail(detail);
		itemsService.updateItems(items);
		return "common/success";
	}*/
	/*
	 * 更新数据,使用对象接收参数,spring会对类型进行转型
	 */
	
	
	/**
	 * 测试请求转发
	 */
	/*@RequestMapping("/updateitem")
	public String updateitem(Items items,HttpServletRequest request){
		itemsService.updateItems(items);
		request.setAttribute("id", items.getId());
		return "forward:/items/sss.action";
	}
	
	@RequestMapping("/sss")
	public String sss(HttpServletRequest request){
		Object attribute = request.getAttribute("id");
		System.out.println(attribute);
		return "forward:/WEB-INF/jsp/common/success.jsp";
	}*/
	
	
	/**
	 * 测试重定向和异常处理
	 */
	/*@RequestMapping("/updateitem")
	public String updateitem(HttpServletRequest request , Items items,Model model,HttpSession session){
		itemsService.updateItems(items);
		//request.setAttribute("id", items.getId());
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("id", items.getId());
		model.addAttribute("id", items.getId());
//		int a = 1/0;
		
//		session.setAttribute(session.getId(), items.getId());
//		System.out.println(modelAndView);
		
		return "redirect:sss.action";
	}
	
	@RequestMapping("/sss")
	public String sss(HttpServletRequest request,Model model,HttpSession session){
		Object id = request.getAttribute("id");
		String parameter = request.getParameter("id");
//		Object id = session.getAttribute(session.getId());
//		System.out.println(model);
		System.out.println(id);
		return "forward:/WEB-INF/jsp/common/success.jsp";
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*/SSM2/WebContent/WEB-INF/jsp/common/success.jsp
	 * 条件查询:/queryitem
	 */
	@RequestMapping("/queryitem")
	public void queryitem(QueryVo vo){
		System.out.println(vo);
		System.out.println(111);
	}
	
	
	@RequestMapping("/listForDel")
	public ModelAndView getListForDel() throws Exception {
		List<Items> itemsList = itemsService.findItemsList();
		ModelAndView modelAndView = new ModelAndView();
		// request.setAttribute(key, value)
		// 底层仍然是把属性名和属性值放到request对象中
		// jsp页面永远是从request对象中取得数据的
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemDel");
		return modelAndView;
	}
	
	
	
	/*@RequestMapping("/delAll")
	public void delAll(Integer [] ids){
		System.out.println(211);
	}*/
	
	
	@RequestMapping("/delAll")
	public void delAll(QueryVo vo){
		System.out.println(211);
	}
	
	
	
	@RequestMapping("/listForUpd")
	public ModelAndView getListForUpd() throws Exception {
		List<Items> itemsList = itemsService.findItemsList();
		ModelAndView modelAndView = new ModelAndView();
		// request.setAttribute(key, value)
		// 底层仍然是把属性名和属性值放到request对象中
		// jsp页面永远是从request对象中取得数据的
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemUpd");
		return modelAndView;
	}
	
	
	@RequestMapping("/updateAll")
	public String updateAll(QueryVo vo) throws Exception {
		System.out.println(vo);
		return "success";
	}
	
	
	
	

}
