/**
 * This class is the main controller for the Bibliotheque application.
 * It handles the HTTP requests and manages the CRUD operations for users and resources.
 * The controller is responsible for rendering the appropriate views and interacting with the database.
 * It also includes methods for adding new books, updating user information, deleting users and resources,
 * and retrieving lists of users and resources.
 * Additionally, it handles user authentication and session management.
 */
package com.bibliotheque.biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.validation.BindingResult; 
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javassist.expr.NewArray;

import java.security.Principal;

@Scope("request")
@Controller
@RequestMapping(path="/")
public class MainController {
   // private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ressourceRepository ressourceRepository;
    @Autowired
    private RestTemplate restTemplate;

    
    @ResponseBody
    @PostMapping("/addbook")
    public String addNewBook(@Valid Ressource ressource, Model model) // (@RequestParam( name="id", required = false, defaultValue = "defaultID") String name)
    {
        ressourceRepository.save(ressource);
        return "New book added";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid Utilisateur utilisateur, BindingResult result, Model model) throws IllegalAccessException{
       // model.addAttribute("utilisateur",utilisateur);
        utilisateur.setIdutilisateur(id);
        userRepository.save(utilisateur);
          return "redirect:/all"; 
       }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) throws IllegalAccessException{
       Utilisateur utilisateur = userRepository.findById(id)
       .orElseThrow(() -> new IllegalAccessException("Idutilusateur non valide : " + id));
        userRepository.delete(utilisateur);
        return "redirect:/all";
    }
    @GetMapping(path = "/edit/{id}")
    public String edit(@RequestParam(name="id", required = true, defaultValue = "1") Integer id, Model model) throws IllegalAccessException{
        Utilisateur utilisateur = userRepository.findById(id)
       .orElseThrow(() -> new IllegalAccessException("Idutilusateur non valide : " + id));
        model.addAttribute("utilisateur",utilisateur);
       // model.getAttribute("id");
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
    public String showUserList( Model model, HttpSession session, Utilisateur utilisateur, Principal principal) {
       // List<Utilisateur> utilisateur = (List<Utilisateur>) userRepository.findAll();
       session.getAttribute("info");
       model.addAttribute("books", new Ressource());
       model.addAttribute("utilisateur", utilisateur);
       model.addAttribute("principal", (principal != null) ? principal.getName() : null);
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
        return "redirect:/allressources";
    }
    
    @GetMapping (path = "/all")
    public String getAllUsers(Model model)
     {   
         model.addAttribute("utilisateur", new Utilisateur());
         //Ceci renvoit un JSON ou XML avec tous les utilisateurs
        return "all";
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
     //Malheureusement cette API ne fonctionne plus
    /* @ModelAttribute("bookInfo")
    public String getCitation(){
        Citation citation = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", 
        Citation.class);
        return citation.toString();
    } */

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
    @RequestMapping("/login?{error}")
    public String connect(@Valid @ModelAttribute("utilisateur") @RequestParam(name="error", required = false)Utilisateur utilisateur, HttpSession session){
        session.setAttribute("info", utilisateur);
        return "index"; 
    }
  /*  @ModelAttribute("session")
    public String sessionparam(HttpSession session){
        session.setAttribute("utilisateur", new Utilisateur());
        Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
        String sessionId = session.getId();
        return sessionId.toString();
    }*/
}

/*
 * 
 */

