package main.java.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.java.entities.Person;
import main.java.repositories.PersonRepository;


@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

	@GetMapping("/persons")
	public String persons(Model model) {

		List<Person> persons = new ArrayList<Person>();

		this.personRepository.findAll().forEach(persons::add);

		model.addAttribute("personsList", persons);

		return "persons";
	}

    @PostMapping("/persons")
    public String savePerson(@ModelAttribute Person person, Model model){

	    System.out.println(person.toString());

        this.personRepository.save(person);

        List<Person> persons = new ArrayList<Person>();

        this.personRepository.findAll().forEach(persons::add);

        model.addAttribute("personsList", persons);

        return "persons";
    }

	@GetMapping("/add_person")
    public String addPerson(Model model){

	    model.addAttribute("person", new Person());
	    return "add-person";
    }

    @GetMapping("/delete_person")
    public String deletePerson(@RequestParam(name="id", required=true) Long id){

	    try {
            this.personRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }
	    return "persons";
    }
}
