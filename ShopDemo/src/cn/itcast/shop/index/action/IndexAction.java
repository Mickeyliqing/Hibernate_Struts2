package cn.itcast.shop.index.action;

import java.util.List;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.category.vo.Category;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport{

	public CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	public String execute(){
	List<Category> cList = categoryService.findAll();
	ActionContext.getContext().getSession().put("cList", cList);
	List<Product> hList = productService.findHot();
	ActionContext.getContext().getValueStack().set("hList", hList);
	List<Product> nList = productService.findNew();
	ActionContext.getContext().getValueStack().set("nList", nList);
	return "index";
	}
}
