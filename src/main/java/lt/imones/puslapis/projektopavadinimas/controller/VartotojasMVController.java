package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Vartotojai;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartotojasMVController {
    @Autowired
    ReceptasRepository receptasRepository;

    @Autowired
    VartotojoRepository vartotojasRepository;

    @PostMapping("/vartotojas/pamegti_recepta/{id}")
    String pamegtiRecepta(@PathVariable int id){
        Vartotojai vartotojas = vartotojasRepository.findById(1);
        vartotojas.getMegstamiReceptai().add(receptasRepository.findById(id));
        vartotojasRepository.save(vartotojas);
        return "pamegtas_receptas.html";
    }
}
