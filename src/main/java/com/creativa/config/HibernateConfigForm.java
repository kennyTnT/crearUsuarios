package com.creativa.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.creativa.entidades.Roles;
import com.creativa.entidades.Usuario;

public class HibernateConfigForm {
	private static SessionFactory sessionPersona;
	 public static SessionFactory getSessionFactoryPersona() {
	        if (sessionPersona == null) {
	            try {
	                Configuration configuration = new Configuration();
	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/formulario");
	                settings.put(Environment.USER, "root");
	                settings.put(Environment.PASS, "");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(Roles.class);
	                configuration.addAnnotatedClass(Usuario.class);
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	                sessionPersona = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionPersona;
	    }
}
