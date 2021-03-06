package com.revature.configuration;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.entities.BenefitPlan;
import com.revature.entities.Company;
import com.revature.entities.Employee;
import com.revature.entities.EmployeeSelection;
import com.revature.entities.Providers;
import com.revature.entities.TypeBenefits;

@Configuration

	@EnableTransactionManagement
	public class HibernateConfig {
	   @Value("${spring.datasource.url}")
	  public String jdbcURl;

	   @Value("${spring.datasource.username}")
	  public String dbUsername;

	   @Value("${spring.datasource.password}")
	  public String dbPassword;

	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	       System.out.println("Configuring seshfactiory bean");
	       LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	       factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

	       factoryBean.setAnnotatedClasses(Company.class, Employee.class, EmployeeSelection.class, BenefitPlan.class, Providers.class, TypeBenefits.class);

	       factoryBean.setDataSource(getDataSource());

	       return factoryBean;
	   }
	   @Bean
	   @Inject
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	       System.out.println("Configuring transaction manager");
	       HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	       transactionManager.setSessionFactory(sessionFactory);
	       return transactionManager;
	   }
	   
//	    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//
//	        authenticationMgr.jdbcAuthentication().dataSource(dataSource())
//	          .usersByUsernameQuery(
//	           "select email,password from user where email=? and statusenable=true")
//	          .authoritiesByUsernameQuery(
//	           "select email,role from user where email=? and statusenable=true");
//
//	        System.out.println(authenticationMgr.jdbcAuthentication().dataSource(dataSource())
//	          .usersByUsernameQuery(
//	           "select email,password from user where email=? and statusenable=true")
//	          .authoritiesByUsernameQuery(
//	           "select email,role from user where email=? and statusenable=true"));
//	    }
	   
	   @Bean(name="dataSource")
	   public DataSource getDataSource() {
	       System.out.println("Getting data source");
	       BasicDataSource dataSource = new BasicDataSource();
	       dataSource.setDriverClassName("org.postgresql.Driver");
	       dataSource.setUrl(jdbcURl);
	       dataSource.setUsername(dbUsername);
	       dataSource.setPassword(dbPassword);
	       return dataSource;
	   }
	   
//	   @Override
//	     protected void configure(HttpSecurity http) throws Exception {
//	    http
//	    .csrf().disable()
//	    .authorizeRequests().antMatchers("/login").permitAll()
//	    .anyRequest().authenticated()
//	    .and()
//	    .formLogin().loginPage("/login").permitAll()
//	    .and()
//	    .authorizeRequests().antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER").anyRequest().permitAll()
//	    .and()
//	    .authorizeRequests().antMatchers("/user/**").hasAnyRole("ROLE_USER").anyRequest().permitAll();

	}

