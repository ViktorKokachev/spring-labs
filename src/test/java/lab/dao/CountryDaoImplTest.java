package lab.dao;


import lab.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {


	private Country exampleCountry = new Country("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
	public void testSaveCountry() {

		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	public void testGtAllCountries() {

		countryDao.save(new Country("Canada", "CA"));

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	public void testGetCountryByName() {

		Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
