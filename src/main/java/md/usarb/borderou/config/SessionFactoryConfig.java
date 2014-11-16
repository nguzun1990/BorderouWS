package md.usarb.borderou.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SessionFactoryConfig {
	
	@Bean(name="sessionFactory")
	public SessionFactory createSessionFactory() {
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;
	}

}
