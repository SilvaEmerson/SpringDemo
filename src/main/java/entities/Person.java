package main.java.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

// A anotação @Entity indica que é uma entidade JPA, por falta de uma anotação @Table
// será assumido que esta entidade será mapeada para a tabela 'Person'
@Entity
public class Person {
	
	// O atributo ID foi anotado com @Id, assim o JPA irá reconhecer como o ID do objeto
	@Id
	// ID foi anotado com @GeneratedValue para indicar que o ID deve ser gerado automaticamente
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String name;
	public int age;
	public String workOn;
	
	protected Person() {}
	
	public Person(String name, int age, String workOn) {
		this.name = name;
		this.age = age;
		this.workOn = workOn;
	}
	
	@Override
	public String toString() {
		return String.format("Person[id=%d, name='%s', age=%d, job='%s'",
				id, name, age, workOn);
	}
	
	public Long getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getWorkOn() {
		return workOn;
	}
}
