package nl.trifork.bootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Value("${foo.bar}")
    private String fooBar;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/config")
    String config() {
        return fooBar;
    }

    @GetMapping("/people")
    List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping("/person")
    void save(@RequestBody Person person) {
        personRepository.save(person);
    }
}
