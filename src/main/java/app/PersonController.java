package main.java.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import main.java.entities.Person;
import main.java.repositories.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/persons")
	public String persons(Model model) {
		List<Person> persons = new ArrayList<Person>();

		personRepository.findAll().forEach(persons::add);

		model.addAttribute("personsList", persons);
		return "persons";
	}
	
}
