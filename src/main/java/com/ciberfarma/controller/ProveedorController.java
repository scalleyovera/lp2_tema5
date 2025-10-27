package com.ciberfarma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciberfarma.model.Proveedor;
import com.ciberfarma.repository.IProveedorRepository;


@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	@Autowired
	private IProveedorRepository repoProv;
	public List<Proveedor> lstProveedor(){
		return repoProv.findAll();
	}
}

