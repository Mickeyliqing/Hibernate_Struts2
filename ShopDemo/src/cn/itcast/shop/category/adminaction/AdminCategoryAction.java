package cn.itcast.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.Category;

@SuppressWarnings("serial")
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {

	private Category category = new Category();

	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	
	public CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public String findAll(){
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	public String save(){
		categoryService.save(category);
		return "saveS";
	}
	
	public String delete(){
		category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		return "deleteS";
	}
	
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		return "editS";
	}
	
	public String update(){
		categoryService.update(category);
		return "updateS";
	}
}
