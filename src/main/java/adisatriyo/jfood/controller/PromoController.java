package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import adisatriyo.jfood.databases.DatabasePromo;
import adisatriyo.jfood.databases.DatabasePromoPostgres;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/promo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class PromoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromoPostgres.getPromoDatabase();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@RequestParam String code) {
        Promo promo = DatabasePromoPostgres.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minimal price") int minPrice,
                          @RequestParam(value = "active") boolean active) {

        Promo promo = promo = new Promo(DatabasePromo.getLastId()+1, code, discount, minPrice, active);
        DatabasePromoPostgres.insertPromo(promo);

        return promo;
    }

}
