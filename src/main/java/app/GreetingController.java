package main.java.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	//@GetMapping garante que a requisição GET HTTP para /greeting é mapeada para greeting()
	@GetMapping("/greeting")
	//@RequestParam liga o valor do parâmetro "name" da requsição até o parâmetro "name" de greeting()
	//e esse "name" do requisição não é obrigatório, e não existindo, o valor padrão é "World"
	//o "name" é adicionado a um objeto Model, tornando ele accessível no template
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}