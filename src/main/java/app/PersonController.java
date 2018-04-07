package main.java.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.entities.Person;
import main.java.repositories.PersonRepository;


@Controller
public class PersonController {



	@GetMapping("/persons")
    @Bean
	public String persons(Model model, PersonRepository personRepository) {

		List<Person> persons = new ArrayList<Person>();

		personRepository.save(new Person("Emerson", 18, "Student"));
		personRepository.save(new Person("Gerson", 19, "Student"));

		personRepository.findAll().forEach(persons::add);

		model.addAttribute("personsList", persons);

		return "persons";
	}

    @PostMapping("/persons")
    @Bean
    public String savePerson(@ModelAttribute Person person, Model model,
                             PersonRepository personRepository){

	    System.out.println(person.toString());

        personRepository.save(person);

        List<Person> persons = new ArrayList<Person>();

        personRepository.findAll().forEach(persons::add);

        model.addAttribute("personsList", persons);

        return "persons";
    }

	@GetMapping("/add_person")
    @Bean
    public String addPerson(Model model, PersonRepository personRepository){
		model.addAttribute("person", new Person());
	    return "add-person";
    }

    @GetMapping("/delete_person")
    @Bean
    public String deletePerson(@RequestParam(name="id", required=true) Long id,
                               PersonRepository personRepository){
        try {
            personRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
	    return "persons";
    }
}
