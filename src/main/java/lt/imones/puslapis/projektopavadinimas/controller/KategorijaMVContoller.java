package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class KategorijaMVContoller {
    @Autowired
    KategorijosRepository kategorijosRepository;

    @GetMapping("/kat/visos_kategorijos")
    String rodytiVisasKategorijas(Model model){
        List<Kategorija> visosKategorijos = kategorijosRepository.findAll();
        model.addAttribute("visosKategorijos", visosKategorijos);
        return "visos_kategorijos.html";
    }

    @GetMapping("/kategorijos/rodyti_receptus")
    String rodytiKategorijjosReceptus(Model model,@RequestParam long id){
        Kategorija kategorija = kategorijosRepository.findById(id);
        model.addAttribute("kategorijosReceptai" , kategorija.getKategorijosReceptai());
        model.addAttribute("kategorijosPavadinimas" , kategorija.getPavadinimas());
        return "kategorijos_receptai.html";
    }

    @PostMapping("/kategorija/ideti_kategorija")
    String idetiKategorija(String pavadinimas){
        Kategorija naujaKategorija = new Kategorija();
        naujaKategorija.setPavadinimas(pavadinimas);
        kategorijosRepository.save(naujaKategorija);
        return "ideta_kategorija.html";
    }

    @GetMapping("/kategorija/kategorijos_idejimas")
    String kategorijisPridejimas(Model model){
        return "ideti_kategorija.html";
    }
}
