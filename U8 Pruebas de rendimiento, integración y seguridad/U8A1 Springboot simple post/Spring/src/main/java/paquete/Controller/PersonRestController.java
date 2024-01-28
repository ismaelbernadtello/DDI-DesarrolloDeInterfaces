package paquete.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import paquete.Model.PersonModel;
import paquete.Repository.PersonRepository;
import paquete.Service.PersonService;


@RestController
public class PersonRestController {

    @Autowired private PersonService personService;

    @Autowired private PersonRepository personRepository;

    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PersonModel person) {
        if (PersonService.isValid(person)) {
            PersonRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}