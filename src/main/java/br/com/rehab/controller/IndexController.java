package br.com.rehab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
 
	@GetMapping
	public String mostraIndex(Model model) {
		model.addAttribute("index", "index");
		return "Index";
	}
}