package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import lab.dao.CountryDao;
import org.springframework.stereotype.Repository;

import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();
		em.persist(country);
	}

	@Override
	public List<Country> getAllCountries() {
//	TODO: Implement it
		return null	;
	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
//		TODO: Implement it

		return null;
	}

}
