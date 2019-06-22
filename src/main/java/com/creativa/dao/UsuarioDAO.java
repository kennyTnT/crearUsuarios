package com.creativa.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.creativa.config.HibernateConfigForm;
import com.creativa.entidades.Roles;
import com.creativa.entidades.Usuario;


@Repository
@Transactional
public class UsuarioDAO {

	public List<Usuario> listarU() {
		try (Session session = HibernateConfigForm.getSessionFactoryPersona().openSession()) {
			return session.createQuery("FROM Usuario", Usuario.class).list();
		}
	}

	public void AddU(Usuario u) {
		try (Session session = HibernateConfigForm.getSessionFactoryPersona().openSession()) {
			 session.save(u);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
