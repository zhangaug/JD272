package cn.itcast.pojo;

import java.util.List;

public class QueryVo {
	
	private Items items;
	
	//使用数组接收前台页面传递的数据
	private Integer [] ids;
	
	//使用集合接收前台页面传递的数据
	private List<Items> updateItemsList;
	
	

	public List<Items> getUpdateItemsList() {
		return updateItemsList;
	}

	public void setUpdateItemsList(List<Items> updateItemsList) {
		this.updateItemsList = updateItemsList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

}
