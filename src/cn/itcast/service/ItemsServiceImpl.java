package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.pojo.Items;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	
	
	@Override
	public List<Items> findItemsList() throws Exception {
		
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(null);
		
		return list;
	}



	@Override
	public Items getItemsDetailById(Integer id) {

		Items items = itemsMapper.selectByPrimaryKey(id);
		
		return items;
	}



	@Override
	public void updateItems(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);		
	}
}
