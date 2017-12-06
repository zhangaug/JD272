package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;

public interface ItemsService {

	public List<Items> findItemsList() throws Exception;

	public Items getItemsDetailById(Integer id);

	public void updateItems(Items items);
}
