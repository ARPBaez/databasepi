package com.vendas.app.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vendas.app.cliente.repository.clienteRepository;


@Controller
public class indexController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");

		String mensagem = "DIGITE A INFORMAÇÃO DESEJADA";
		mv.addObject("msg", mensagem);

		return mv;
	}


	@Autowired
	clienteRepository fr;
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar) {
		ModelAndView mv = new ModelAndView("index");

		String mensagem = "Resultado da Pesquisa !";		
		
		mv.addObject("msg", mensagem);		
		mv.addObject("cliente", fr.findByNomes(buscar) );

		return mv;
	}

}
