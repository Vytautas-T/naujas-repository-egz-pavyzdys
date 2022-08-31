package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KategorijosController {

    @Autowired
    KategorijosRepository kategorijosRepository;

   @PostMapping ("/testinits/ideti")
   String idetiKategorija(String pavadinimas){
       Kategorija naujaKategorija = new Kategorija();
       naujaKategorija.setPavadinimas(pavadinimas);
       kategorijosRepository.save(naujaKategorija);
       return "Kategorija " + pavadinimas + " ideta sekmingai";
   }
}
