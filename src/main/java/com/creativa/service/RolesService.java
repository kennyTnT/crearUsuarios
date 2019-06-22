package com.creativa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creativa.dao.RolesDAO;
import com.creativa.entidades.Roles;

@Service
@Transactional
public class RolesService {

	@Autowired
	 RolesDAO dao;

	public  List<Roles> listar() {
		return dao.listar();
	}

	public void Add(Roles rol) {
		dao.Add(rol);
	}


}
