package cn.itcast.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.product.vo.Product;
import cn.itcast.shop.untils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{

	@SuppressWarnings("unchecked")
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询热门的商品，条件是is_host=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> List = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return List;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findNew() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> List = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return List;
	}

	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	@SuppressWarnings("unchecked")
	public int findCountCid(Integer cid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if(list!= null && list.size()>0){
			return list.get(0).intValue();
		}else{
			return 0;
		}
	}

	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		return list;
	}

	@SuppressWarnings("unchecked")
	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		String hql= "select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		return list;
	}

	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		return list;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(product);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
	}
}
