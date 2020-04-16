package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/promo")
@RestController

public class PromoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@RequestParam String code) {
        Promo promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minimal price") int minPrice,
                          @RequestParam(value = "active") boolean active) {

        Promo promo = promo = new Promo(DatabasePromo.getLastId()+1, code, discount, minPrice, active);
        try {
            DatabasePromo.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return promo;
    }

}
