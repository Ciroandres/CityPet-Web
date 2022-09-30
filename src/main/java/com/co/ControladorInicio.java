
package com.co;

//Anotación de controles --- class controladora...

import com.co.dao.nombreDAO;
import com.co.pojo.nombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {
    //inyectar DAO
    @Autowired
    private nombreDAO nombreDAO;
    
    //Mapeo con Get -- Mostrar la página...
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
   
    @GetMapping("/login")
    public String iniciosesion(){
        return "iniciosesion";
    }
    
    @GetMapping("/loginadmin")
    public String loginadmin(Model model){
        var nombre = nombreDAO.findAll();
        model.addAttribute("clientes",nombre);
        return "loginadmin";
    }    
    
     @GetMapping("/crear")
    public String crear(){
        return "crear";
    }
    
     @PostMapping("/guardar")
    public String guardar(@ModelAttribute nombre nombre){
        nombreDAO.save(nombre);
        return "redirect:/loginadmin";
    }
    
    @GetMapping("/editar/{idnombre}")
    public String editar(@PathVariable("idenombre") String idnombre, Model model){
        var nombre = nombreDAO.findById(idnombre);
        model.addAttribute("nombre",nombre);
        return "modificar";
    }
    
     @GetMapping("/eliminar/{idnombre}")
    public String eliminar(@PathVariable("idnombre") String idnombre){
        nombreDAO.deleteById(idnombre);
        return "redirect:/loginadmin";
    }
    
}
    
    
   

