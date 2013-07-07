package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import repository.GeneroRepository;
import entities.Genero;

@ManagedBean
public class GeneroBean {
	@ManagedProperty(value="#{entityManager}")
    private EntityManager entityManager;
 
    private List<Genero> generos = null;
     
    public List<Genero> getGeneros() {
        if(this.generos == null){
            GeneroRepository repository = new GeneroRepository(entityManager);
            this.generos = repository.getGeneros();
        }
         
        return this.generos;
    }
 
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}