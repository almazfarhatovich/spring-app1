package almaz.controllers;

import almaz.dao.PersonDao;
import almaz.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("people", personDao.findAll());
        return "people/getAll";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", personDao.findById(id));
        return "people/findById";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "people/new";
        }
        personDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", personDao.findById(id));
        return "people/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult,
                         @PathVariable("id") long id) {
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        personDao.deleteById(id);
        return "redirect:/people";
    }

}
