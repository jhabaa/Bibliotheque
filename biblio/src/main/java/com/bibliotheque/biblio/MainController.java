package com.bibliotheque.biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javassist.expr.NewArray;

@BindingResult
@Controller
@RequestMapping(path="/")
public class MainController {
   // private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ressourceRepository ressourceRepository;
    
    @ResponseBody
    @PostMapping("/addbook")
    public String addNewBook(@Valid Ressource ressource, Model model) // (@RequestParam( name="id", required = false, defaultValue = "defaultID") String name)
    {
       // model.addAttribute("ressource", ressource);
        /*Utilisateur n = new Utilisateur();
        n.setNom("ddf");
        n.setUid("777");
        userRepository.save(n);*/
        ressourceRepository.save(ressource);
        return "New book added";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) throws IllegalAccessException{
       Utilisateur utilisateur = userRepository.findById(id)
       .orElseThrow(() -> new IllegalAccessException("Idutilusateur non valide : " + id));
        userRepository.delete(utilisateur);
        return "redirect:/all";
    }
    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        // non terminé
        return "all";
    }
    @GetMapping("/deleteressource/{id}")
    public String delete(@PathVariable("id") String id, Model model) throws IllegalAccessException{
        Ressource ressource = ressourceRepository.findById(id).orElseThrow(
            () -> new IllegalAccessException("Id ressource non valide :" + id)
        );
        ressourceRepository.delete(ressource);
        return "redirect:/allressources";
    }

 
    @GetMapping("/")
    public String showUserList( @PathParam("nom") String name ,Model model) {
       // List<Utilisateur> utilisateur = (List<Utilisateur>) userRepository.findAll();
        model.addAttribute("book", new Ressource());
        return "index";
    }


    @PostMapping("/newUser")
    public String newUser(@Valid Utilisateur utilisateur, Model model){
        userRepository.save(utilisateur);
        return "redirect:/all";
    }
    @PostMapping("/addressource")
    public String addRessource(@Valid Ressource ressource, Model model){
        ressourceRepository.save(ressource);
        return "redirect:/allressource";
    }
    
    @GetMapping (path = "/all")
    public String getAllUsers(Model model)
     {   
         model.addAttribute("utilisateur", new Utilisateur());
         //Ceci renvoit un JSON ou XML avec tous les utilisateurs
        return "all";
        // return (Utilisateur) userRepository.findAll();
     }
     @GetMapping(value = "subscription")
     //@GetMapping("/subscription")
     public Iterable<Utilisateur> greeting(@ModelAttribute("Utilisateur") @Valid Utilisateur utilisateur , Model model, BindingResult result ){
        // model.addAttribute("name", name);
         return userRepository.findAll();
     }

     @GetMapping("/addbook")
     public String books(@ModelAttribute("Ressource") @Valid Ressource ressource, Model model, BindingResult result )
     {
         return "addbook";
     }

     @ModelAttribute("utilisateurs")
        public Iterable<Utilisateur> utilisateurs() {
            return  userRepository.findAll();
        }
    @ModelAttribute("ressources")
    public Iterable<Ressource> ressources(){
        return ressourceRepository.findAll();
    }
      /*  @RequestMapping(value = "/subscription", method = RequestMethod.GET)
    public String utilisateurs(Model model) {
    model.addAttribute("utilisateurs", utilisateurs);
    return "subscription";
        }     */
    @GetMapping (path = "/allressources")
    public String getAllressources(Model model)
    {
    model.addAttribute("ressource", new Ressource());
            return "allressources";
    }
}

