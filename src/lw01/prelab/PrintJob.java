package lw01.prelab;

public abstract class PrintJob implements Chargeable { //abstarct can implement many interface
    private String id;
    private int pages;

    protected PrintJob (String id, int pages){
        if (pages <= 0){
            throw new IllegalArgumentException("pages must be greater than 0");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }    

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        if (copies <= 0){
            throw new IllegalArgumentException("copies harus positif");
        }
        return copies * calculateCharge();
    }

    public String label(){
        return "print";
    }

    public String summary(){
        return id + "|" + label() + "|" + calculateCharge();
    }
}
 