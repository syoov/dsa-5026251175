package lw01.unguided;

public abstract class WashService implements Billable{
    private String id;
    private int days;
    
    protected WashService (String id, int days){

        if(days <= 0){
            throw new IllegalArgumentException("days must not be zero");
        }
        this.id=id;
        this.days=days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if (units<=0){
            throw new IllegalArgumentException("units must be positive");
        }

        return units*calculateCharge();
    }

    public String label(){
        return "service";
    }

    public String summary(){
        return id + "|" + label() + "|" + calculateCharge();
    }
}
