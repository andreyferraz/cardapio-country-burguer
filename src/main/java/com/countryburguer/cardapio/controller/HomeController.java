package com.countryburguer.cardapio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("pageTitle", "Country Burguer | Cardapio Digital");
        model.addAttribute("pageDescription", "Cardapio digital Country Burguer no estilo faroeste. Escolha hamburgueres, crepes, porcoes e finalize seu pedido.");
        model.addAttribute("heroTitle", "Country Burguer");
        model.addAttribute("heroSubtitle", "Hamburgueria Artesanal");
        return "index";
    }

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {
        model.addAttribute("pageTitle", "Country Burguer | Login Admin");
        model.addAttribute("pageDescription", "Acesso administrativo do painel Country Burguer.");
        model.addAttribute("hasError", error != null);
        model.addAttribute("hasLogout", logout != null);
        return "login";
    }
}
