package lw01.prelab;

public class Colourprint extends PrintJob {

    private static final int harga10Pertama = 1500;
    private static final int hargaBeyond10 = 1000;
    private static final int hargaSetup = 2000;
    private static final int batasTierHarga = 10;

    public Colourprint(String id, int pages){
      super(id, pages) ; 
    }

    @Override 
    public int calculateCharge(){
        int pages = getPages();
        int charge;
        if (pages <= batasTierHarga) {
            charge = pages * harga10Pertama;
        } else {
            charge = (batasTierHarga * harga10Pertama) + ((pages - batasTierHarga) * hargaBeyond10);
        }
        charge += hargaSetup;
        return charge;
    }

    @Override 
    public String label() {
        return "Colour";
    }
} 
