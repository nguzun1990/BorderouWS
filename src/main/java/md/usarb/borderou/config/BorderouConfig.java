package md.usarb.borderou.config;

import md.usarb.borderou.common.FormatedList;
import md.usarb.borderou.dao.FacultateDao;
import md.usarb.borderou.entities.licenta.EntityInterface;
import md.usarb.borderou.service.FacultateService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan({ "md.usarb.borderou.dao",  "md.usarb.borderou.service", "md.usarb.borderou.web.controller"})
@EnableTransactionManagement
@EnableWebMvc
public class BorderouConfig<T extends EntityInterface> {
	
	@Bean
	public FormatedList<T> getFormatListObject() {
		return new FormatedList<T>();
	}
	
	/*@Bean(name = "facultateDao")
	public FacultateDao getFacultateDao() {
		return FacultateDao.getInstance();
	}*/
	
	
	/*@Bean(name = "facultateService")
	public FacultateService getFacultateService() {
		return new FacultateService();
	}*/

}
