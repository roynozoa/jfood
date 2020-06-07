package adisatriyo.jfood.controller;

import adisatriyo.jfood.*;
import adisatriyo.jfood.databases.DatabaseLocationPostgres;
import adisatriyo.jfood.databases.DatabaseSeller;
import adisatriyo.jfood.databases.DatabaseSellerPostgres;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/seller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class SellerController {
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ArrayList<Seller> getAllSeller() {
//        return DatabaseSellerPostgres.getSellerDatabase();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        seller = DatabaseSellerPostgres.getSellerById(id);

        return seller;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="phoneNumber") String phoneNumber,
                          @RequestParam(value="province") String province,
                          @RequestParam(value="description") String description,
                          @RequestParam(value="city") String city){

        Seller seller = seller = new Seller(DatabaseSellerPostgres.getLastId()+1, name, email, phoneNumber, new Location(DatabaseLocationPostgres.getLastId()+1, city, province, description));
        DatabaseSellerPostgres.insertSeller(seller);
        return seller;
    }
}
