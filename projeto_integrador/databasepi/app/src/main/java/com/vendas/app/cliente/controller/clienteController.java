package com.vendas.app.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vendas.app.cliente.models.cliente;
import com.vendas.app.cliente.repository.clienteRepository;


@Controller
public class clienteController {

	@Autowired
	private clienteRepository fr;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String abrircliente() {
		return "cliente/cliente";
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String gravarcliente(cliente cliente) {
		fr.save(cliente);
		return "redirect:/cliente";
	}

}
