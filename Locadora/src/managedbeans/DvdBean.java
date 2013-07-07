package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import repository.DvdRepository;
import repository.GeneroRepository;

import entities.DVD;
import entities.Genero;

@ManagedBean
public class DvdBean {
	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	
	private DVD dvd = new DVD();
	private List<DVD> dvds;
	private Long generoID;
	
    public void save() {
        GeneroRepository generoRepository = new GeneroRepository(this.entityManager);
        Genero genero = generoRepository.search(generoID);
        this.dvd.setGenero(genero);
         
        DvdRepository dvdRepository = new DvdRepository(this.entityManager);
        dvdRepository.save(this.dvd);
         
        this.dvd = new DVD();
        this.dvds = null;
    }
     
    public void remove(DVD dvd) {
        DvdRepository repository = new DvdRepository(this.entityManager);
        repository.remove(dvd);
         
        this.dvds = null;
    }
     
    public List<DVD> getDvds() {
        if(this.dvds == null){
            DvdRepository repository = new DvdRepository(this.entityManager);
            this.dvds = repository.getDVDs();
        }
         
        return this.dvds;
    }
     
    public Long getCount() {
        DvdRepository repository = new DvdRepository(this.entityManager);
         
        return repository.getCountDVDs();
    }
 
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	public DVD getDvd() {
		return dvd;
	}

	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	public Long getGeneroID() {
		return generoID;
	}

	public void setGeneroID(Long generoID) {
		this.generoID = generoID;
	}

	public void setDvds(List<DVD> dvds) {
		this.dvds = dvds;
	}
}
