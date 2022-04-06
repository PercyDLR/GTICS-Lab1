package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/juegos")
public class GamesController {

    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    PlatformsRepository platformsRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){
        List<Games> gamesList = gamesRepository.findAll();
        model.addAttribute("gamesList", gamesList);
        return "juegos/lista";
    };

    @GetMapping("/editar")
    public String editarJuegos(@RequestParam("id") Integer id, Model model){
        Optional<Games> optionalGames = gamesRepository.findById(id);
        if (optionalGames.isPresent()) {
            Games game = optionalGames.get();
            model.addAttribute("game", game);
            List<Platforms> platformsList = platformsRepository.findAll();
            model.addAttribute("platformsList", platformsList);
            return "juegos/editar";
        } else {
            return "redirect:/juegos/lista";
        }
    };

    @PostMapping("/guardar")
    public String guardarJuegos(Games game){
        gamesRepository.save(game);
        return "redirect:/juegos/lista";
    };


    @GetMapping("/borrar")
    public String borrarJuegos(@RequestParam("id") Integer id){
        gamesRepository.deleteById(id);
        return "redirect:/juegos/lista";
    }
}
