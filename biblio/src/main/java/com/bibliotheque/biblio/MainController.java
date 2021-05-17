package com.bibliotheque.biblio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@BindingResult
@Controller
@RequestMapping(path="/")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    
    
    @PostMapping("/add")
    public String addNewUser (Utilisateur utilisateur, Model model) // (@RequestParam( name="id", required = false, defaultValue = "defaultID") String name)
    {
        model.addAttribute("utilisateur", utilisateur);
        /*Utilisateur n = new Utilisateur();
        n.setNom("ddf");
        n.setUid("777");
        userRepository.save(n);*/
        return "page1";
    }
    @ResponseBody
    @PostMapping("/newUser")
    public String newUser(Utilisateur utilisateur, Model model){
        model.addAttribute("utilisateur", utilisateur);
        return "OK";
    }
    
    @GetMapping(path = "/all")
    public @ResponseBody Utilisateur getAllUsers()
     {
         //Ceci renvoit un JSON ou XML avec tous les utilisateurs
         return userRepository.getUtilisateur("Sam");
         //return userRepository.findAll();
     }
     @GetMapping("/subscription")
     public String greeting(@ModelAttribute("Utilisateur") @Valid Utilisateur utilisateur , Model model, BindingResult result ){
        // model.addAttribute("name", name);
         return "subscription";
     }
}

