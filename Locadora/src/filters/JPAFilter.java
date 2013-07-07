package filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class JPAFilter
 */
@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter {
	
	private EntityManagerFactory entityManagerFactory;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.entityManagerFactory.close();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EntityManager entityManager = this.entityManagerFactory
                .createEntityManager();
		request.setAttribute("entityManager", entityManager);
		entityManager.getTransaction().begin();
		chain.doFilter(request, response);
		
		try{
			 entityManager.getTransaction().commit();
		}catch (Exception e){
			entityManager.getTransaction().rollback();
            throw new ServletException(e.toString());
		}finally{
			 entityManager.close();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 this.entityManagerFactory = Persistence
	                .createEntityManagerFactory("Locadora");
	}

}
