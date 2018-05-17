package fr.eservices.drive.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

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
			List<Category> categories = em.createQuery("select c from Article a join a.categories c where a.id=:idC",Category.class).setParameter("idC",id).getResultList();
			return categories;

	}

	@Override
	public List<Article> getCategoryContent(int categoryId) {
		List<Article> articles = em.createQuery("select a From Article a join a.categories c where c.id=:categoryId",Article.class).setParameter("categoryId",categoryId).getResultList();
		return articles;
	}

	@Override
	public List<Perishable> getPerished(Date day) {
		List<Perishable> perishables = em.createQuery("select p from Perishable p where bestBefore=:day").setParameter("day",day).getResultList();
		return perishables;
	}

	
}
