/**
 * Kelas PaymentType berguna untuk menyimpan tipe makanan
 * Kelas berupa eNum yang menyimpan array tipe makanan
 * 
 * @author (Muhammad Adisatriyo Pratama)
 * @version (9/4/2020)
 */
package adisatriyo.jfood;

public enum PaymentType{
    Cashless("Cashless"),
    Cash("Cash");
    
    private String type;
    
    /**
     * method untuk mendapatkan tipe payment
     */
    private PaymentType(String type){
        this.type = type;
    }
    /**
     * mengubah tipe payment menjadi string
     */
    public String toString(){
        return type;
    }
}


