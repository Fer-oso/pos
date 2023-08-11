package entitys;

public class Checking {

        private int id;
        private CarShop carshop;
        private int imps;

    public Checking() {
    }

    public Checking(int id, CarShop carshop, int imps) {
        this.id = id;
        this.carshop = carshop;
        this.imps = imps;
    }

    public int getImps() {
        return imps;
    }

    public void setImps(int imps) {
        this.imps = imps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarShop getCarshop() {
        return carshop;
    }

    public void setCarshop(CarShop carshop) {
        this.carshop = carshop;
    }

    @Override
    public String toString() {
        return "Cheking{" + "id=" + id + ", carshop=" + carshop + ", imps=" + imps + '}';
    }
        
        
        
    }