package md.usarb.borderou.config;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "md.usarb.borderou.*" })
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig {
	
	
//	@Bean
//    public SessionFactory sessionFactory() {
//    	org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//    	configuration.configure("hibernate.cfg.xml");
//    	SessionFactory sessionFactory =configuration.buildSessionFactory();
//    	return sessionFactory;
//
//    	
//    }
 
        @Bean
        public SessionFactory sessionFactory() {
                LocalSessionFactoryBuilder builder = 
			new LocalSessionFactoryBuilder(dataSource());
                builder.scanPackages("md.usarb.borderou.vo")
                      .addProperties(getHibernateProperties());
 
                return builder.buildSessionFactory();
        }
 
	private Properties getHibernateProperties() {
                Properties prop = new Properties();
                prop.put("hibernate.format_sql", "true");
                prop.put("hibernate.show_sql", "true");
                prop.put("hibernate.dialect", 
                    "org.hibernate.dialect.SQLServerDialect");
                return prop;
        }
 
	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {
 
		BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("net.sourceforge.jtds.jdbcx.JtdsDataSource");
		ds.setUrl("jdbc:jtds:sqlserver://devt.usb.md;databaseName=Baza_Studenti_test");
		ds.setUsername("programer");
		ds.setPassword("pr0gr@mer");
		return ds;
	}
 
	//Create a transaction manager
	@Bean
    public HibernateTransactionManager txManager() {
            return new HibernateTransactionManager(sessionFactory());
    }

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
 
}
