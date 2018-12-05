package cn.itcast.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.categorysecond.vo.CategorySecond;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.untils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	private ProductService productService;
	private CategorySecondService categorySecondService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	private File upload;
	private String uploadFileName;
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String findAll(){
		PageBean<Product> pageBean = productService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	public String addPage(){
		List<CategorySecond> cList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPageS";
	}
	
	public String save() throws IOException{
		// 将提交的数据添加到数据库中.
		product.setPdate(new Date());
		if(upload != null){
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+ uploadFileName);
		}
		productService.save(product);
		return "saveS";
	}
	
	public String delete(){
		// 根据id查询商品信息
		product = productService.findByPid(product.getPid());
		// 删除商品的图片:
		String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
		File file = new File(path);
		// 删除数据库中商品记录:
		file.delete();
		productService.delete(product);
		return "deleteS";
	}
	
	public String edit(){
		product = productService.findByPid(product.getPid());
		List<CategorySecond> cList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editS";
	}
	
	public String update() throws IOException{
		product.setPdate(new Date());
		
		if(upload != null){
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			File diskFile = new File(path + "//" + uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/" + uploadFileName);
		}
		productService.update(product);
		return "updateS";
	}
}
