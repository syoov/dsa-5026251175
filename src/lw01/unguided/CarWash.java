package lw01.unguided;

public class CarWash extends WashService{

    public CarWash (String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int days = getDays();
        int charge;

        if(days<=3){
            charge = 35000;
        } else {
            charge = (3*35000) + ((getDays()-3)*25000) + 15000;
        }

        charge += 2000;
        return charge;
    }

    @Override 
    public String label(){
        return "CAR";
    }
}
