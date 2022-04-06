package pe.edu.pucp.gtics.lab1221.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"","/inicio"})
    public String paginaInicio(){
        return "index";
    }
}
