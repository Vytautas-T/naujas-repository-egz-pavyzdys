package lt.imones.puslapis.projektopavadinimas.controller;

import lt.imones.puslapis.projektopavadinimas.model.dto.IngredientaiDto;
import lt.imones.puslapis.projektopavadinimas.model.entity.Ingredientai;
import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.entity.Receptai;
import lt.imones.puslapis.projektopavadinimas.model.repository.IngredientaiRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.ReceptasRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.VartotojoRepository;
import lt.imones.puslapis.projektopavadinimas.service.ReceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class ReceptasMVController {
    @Autowired
    ReceptoService receptoService;

    @Autowired
    ReceptasRepository receptasRepository;
    @Autowired
    KategorijosRepository kategorijosRepository;

    @Autowired
    VartotojoRepository vartotojoRepository;

    @Autowired
    IngredientaiRepository ingredientaiRepository;


    @GetMapping("/test/sveikinimas")
    String testineFuncija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }


    @GetMapping("/rasti/recepta")
    String ieskomasReceptas(Model model, @RequestParam String pavadinimas) {
        Receptai receptas = receptasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("id", receptas.getId());
        model.addAttribute("pavadinimas", receptas.getPavadinimas());
        model.addAttribute("nurodymai", receptas.getNurodymai());
        model.addAttribute("kalorijosPer100g", receptas.getKalorijosPer100g());
        model.addAttribute("kaina", receptas.getKaina());
        model.addAttribute("receptoIngredientai", receptas.getReceptoIngredientai());
        model.addAttribute("receptoKurejas", receptas.getReceptoKurejas());
        model.addAttribute("receptoKategorija", receptas.getReceptoKategorija());
        return "parodyti_recepta.html";
    }

    @GetMapping("/rasti/rasti_recepta_id")
    String ieskomasReceptasPagalId(Model model, @RequestParam int id) {
        Receptai receptas = receptasRepository.findById(id);
        model.addAttribute("id", receptas.getId());
        model.addAttribute("pavadinimas", receptas.getPavadinimas());
        model.addAttribute("nurodymai", receptas.getNurodymai());
        model.addAttribute("kalorijosPer100g", receptas.getKalorijosPer100g());
        model.addAttribute("kaina", receptas.getKaina());
        model.addAttribute("receptoIngredientai", receptas.getReceptoIngredientai());
        model.addAttribute("receptoKurejas", receptas.getReceptoKurejas());
        model.addAttribute("receptoKategorija", receptas.getReceptoKategorija());
        return "parodyti_recepta.html";
    }

    @GetMapping("/recep/visi_receptai")
    String rodytiVisusReceptus(Model model){
        List<Receptai> visisReceptai = receptasRepository.findAll();
        model.addAttribute("visiReceptai", visisReceptai);
        return "visi_receptai.html";
    }

    @GetMapping("recep/meniu")
        String receptmeniu(Model model){
        return "meniu.html";
    }

    @GetMapping("/recep/paieska")
    String testPaieska(Model model) {
        return "rasti_recepta.html";
    }

    @GetMapping("/recepto/recepto_idejimas")
    String receptoIdejimas(Model model) {
        String ingredientai = "";
        Set ingreSet = receptoService.KonvertavimasIsStringISet(ingredientai);
        Receptai receptas = new Receptai();
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijosRepository.findAll());
        model.addAttribute("vartotojei", vartotojoRepository.findAll());
        return "ideti_recepta.html";
    }

    @PostMapping("/recepto/idejo_recepta")
    String pridetiRecepta(@ModelAttribute Receptai ivedamasReceptas,@RequestParam String ingredientai) {
        Set<Ingredientai> ingrePavadinimas = receptoService.KonvertavimasIsStringISet(ingredientai);
        ivedamasReceptas.setReceptoIngredientai(ingrePavadinimas);
        receptasRepository.save(ivedamasReceptas);
        return "idetas_receptas.html";
    }

    @GetMapping("/recep/redaguoti_recepta/{id}")
    String redaguotiRecepta(Model model, @PathVariable long id) {
        Receptai receptas = receptasRepository.findById(id);
        model.addAttribute("ingredientai", receptoService.ingredientuSetuConvertatorius(receptas.getReceptoIngredientai()));
        model.addAttribute("receptas", receptas);
        model.addAttribute("kategorijos", kategorijosRepository.findAll());
        return "recepto_redagavimas.html";
    }

    @PostMapping("/recep/istrinti_recepta/{id}")
    String istrintiRecepta(Model model, @PathVariable long id) {
        receptasRepository.delete(receptasRepository.findById(id));
        return "istrintas_receptas.html";
    }

    @GetMapping("/recep/ideti_ingredientus/{id}")
    String idetiIngredientus(Model model, @PathVariable long id) {
        IngredientaiDto ivedamasObjiektas = new IngredientaiDto();
        ivedamasObjiektas.setReceptoId(id);
        model.addAttribute("ingredientai", ivedamasObjiektas);
        System.out.println(ivedamasObjiektas);
        return "ingredientu_idejimas.html";
    }

    @PostMapping("/recep/ideti_ingredientus")
    String ingreIdetas(Model model, @ModelAttribute IngredientaiDto ingredientai) {
        Receptai isaugomasReceptas = receptasRepository.findById(ingredientai.getReceptoId());
        Set<Ingredientai> ingreSet = isaugomasReceptas.getReceptoIngredientai();
        String stringingre = receptoService.konvertavimasIsSetIString(ingreSet);
        String sudetas = stringingre + ingredientai.getPavadinimai();
        isaugomasReceptas.setReceptoIngredientai(receptoService.KonvertavimasIsStringISet(sudetas));
        receptoService.KonvertavimasIsStringISet(ingredientai.getPavadinimai());
        isaugomasReceptas.setReceptoIngredientai(ingreSet);
        receptasRepository.save(isaugomasReceptas);
        return "puslapis2.html";
    }
}