package com.creativa.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.creativa.config.HibernateConfigForm;
import com.creativa.entidades.Roles;


@Repository
@Transactional
public class RolesDAO {

	public List<Roles> listar() {
		try (Session session = HibernateConfigForm.getSessionFactoryPersona().openSession()) {
			return session.createQuery("FROM Roles", Roles.class).list();
		}
	}

	public void Add(Roles r) {
		try (Session session = HibernateConfigForm.getSessionFactoryPersona().openSession()) {
			 session.save(r);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
