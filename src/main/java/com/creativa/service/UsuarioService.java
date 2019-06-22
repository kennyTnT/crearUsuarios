package com.creativa.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.creativa.dao.UsuarioDAO;
import com.creativa.entidades.Roles;
import com.creativa.entidades.Usuario;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	 UsuarioDAO dao;

	public  List<Usuario> listarU() {
		return dao.listarU();
	}

	public void AddU(Usuario user) {
		dao.AddU(user);
	}
}
