/**
 * Kelas FoodCategory berguna untuk menyimpan kategori makanan
 * Kelas berupa eNum yang menyimpan array makanan
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */

public enum FoodCategory{
    Beverages("Beverages"),
    Coffee("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"),
    Japanese("Japanese");

    private String category;
    /**
     * method untuk mendapatkan kategori
     */
    private FoodCategory(String category){
        this.category = category;
    }
    /**
     * mengubah category menjadi string
     */
    public String toString(){
        return category;
    }
}