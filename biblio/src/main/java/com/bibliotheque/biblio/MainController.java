package com.bibliotheque.biblio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public @ResponseBody String addNewUser (Utilisateur utilisateur, Model model) // (@RequestParam( name="id", required = false, defaultValue = "defaultID") String name)
    {
        model.addAttribute("utilisateur", utilisateur);
        /*Utilisateur n = new Utilisateur();
        n.setName("3 pretendants");
        n.setIdutilisateur("47");
        userRepository.save(n);*/
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Utilisateur> getAllUsers()
     {
         //Ceci renvoit un JSON ou XML avec tous les utilisateurs
         return userRepository.findAll();
     }
     @GetMapping("/greeting")
     public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){
         model.addAttribute("name", name);
         return "greeting";
     }

}
