package com.mphasis.spring.SpringJdbcAOPDemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mphasis.spring.SpringJdbcAOPDemo.Db.EmployeeDB;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(App.class);
        
        EmployeeDB emp = context.getBean(EmployeeDB.class);
        System.out.println(emp.count());
    }
    
    @Bean
    public DataSource dataSource()
    {   
        System.out.println("Connecting to DataBase");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("skv");
        ds.setPassword("skvp0702");
        return ds;
    }
    @Bean
    @Autowired
    public JdbcTemplate template(DataSource ds)
    {
        System.out.println("connecting jdbc template");
        return new JdbcTemplate(ds);
    }
}

