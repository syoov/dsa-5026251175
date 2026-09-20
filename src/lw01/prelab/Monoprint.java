package lw01.prelab;

public class Monoprint extends PrintJob{

    private static final int hargaPerPage = 500;

    public Monoprint (String id, int pages){
        super(id, pages);
    }

    @Override 
    public int calculateCharge(){
        return getPages() * hargaPerPage;
    }

    @Override 
    public String label(){
        return "Mono";
    }
}
