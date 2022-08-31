package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceptasController {

    @Autowired
    ReceptasRepository receptasRepository;

    @GetMapping("/recep/gauti_id")
    Receptai gautiPagalId(@RequestParam long id) {
        System.out.println(id);
        return receptasRepository.findById(id);
    }

    @GetMapping("/recep/gauti_pav")
    Receptai gautiPagalPavadinimas(@RequestParam String pavadinimas) {
        System.out.println(pavadinimas);
        return receptasRepository.findByPavadinimas(pavadinimas);
    }

    @GetMapping("/recep/gauti_kaina")
    Receptai gautiPagalKaina(@RequestParam double kaina) {
        return receptasRepository.findByKaina(kaina);
    }

    @GetMapping("/test/greeting")
    String testinisEndpoint() {
        return "šis puslapis veikia";
    }

    @PostMapping("/recep/ideti_recepta")
    String idetiRecepta(@RequestBody Receptai ivedamasReceptas) {
        receptasRepository.save(ivedamasReceptas);
        return "idejo";
    }
}


//http://localhost:8080/rasti/recepta