package com.vendas.app.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vendas.app.cliente.models.cliente;
import com.vendas.app.cliente.repository.clienteRepository;

@Controller
public class listaclienteController {

	@Autowired
	private clienteRepository fr;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView listarcliente() {
		ModelAndView mv = new ModelAndView("cliente/listacliente");
		mv.addObject("cliente", fr.findAll());
		return mv;
	}

	@RequestMapping(value = "/deletarcliente/{id}", method = RequestMethod.GET)
	public String deletarcliente(@PathVariable("id") long id) {
		fr.delete(fr.findById(id));
		return "redirect:/lista";
	}

	@RequestMapping(value = "/editarcliente/{id}", method = RequestMethod.GET)
	public ModelAndView abrireditarcliente(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("cliente/editarcliente");
		mv.addObject("cliente", fr.findById(id));
		return mv;
	}

	@RequestMapping(value = "/editarcliente/{id}", method = RequestMethod.POST)
	public String updatecliente(cliente cliente) {
		fr.save(cliente);
		return "redirect:/lista";
	}
}