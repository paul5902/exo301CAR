package fr.eservices.drive.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import fr.eservices.drive.model.Perishable;

public class CatalogDaoJPAImpl implements CatalogDao {

	private EntityManager em;
	
	public CatalogDaoJPAImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Category> getCategories() throws DataException {
			List<Category> categories = em.createQuery("from Category order by orderIdx",Category.class).getResultList();
			return categories;


	}

	@Override
	public List<Category> getArticleCategories(int id) throws DataException {
			Article article = em.find(Article.class,id);
			if(article == null) {
				throw new DataException("ko");
			}
			List<Category> categories = em.createQuery("select c from Article a join a.categories c where a.id=:idC",Category.class).setParameter("idC",id).getResultList();
			return categories;

	}

	@Override
	public List<Article> getCategoryContent(int categoryId) throws DataException {
		Category category = em.find(Category.class,categoryId);
		if(category == null) {
			throw new DataException("ko");
		}
		List<Article> articles = em.createQuery("select a From Article a join a.categories c where c.id=:categoryId",Article.class).setParameter("categoryId",categoryId).getResultList();
		return articles;
	}

	@Override
	public List<Perishable> getPerished(Date day) throws DataException {
		List<Perishable> perishables = em.createQuery("select p from Perishable p where bestBefore<=:day").setParameter("day",day,TemporalType.DATE).getResultList();
		if(perishables.size()>=200) {
			throw new DataException("ko");
		}
		return perishables;
	}

	
}
