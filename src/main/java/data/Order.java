package data;

public class Order extends Dish {


    public enum Type { st, mc, ds}

    private String customerName;
    private String dishName;
    public Type enumType;
    private String type;
    private boolean gfd;
    private boolean vdg;
    private boolean hmd;
    private boolean sfd;
    private Object extras;


    public Order(){}


    public Order (String customerName, String dishName, String type, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String extras) {
        this.customerName = customerName;
        this.dishName = dishName;
        this.gfd = gfd;
        this.vdg = vgd;
        this.hmd = hmd;
        this.sfd = sfd;
        this.extras = extras;

    }

    public Order(String customerName, Dish dish){

    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getDishName() {
        return dishName;
    }

    @Override
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }


    public void setEnumType(Type enumType) {
        this.enumType = enumType;
    }

    public boolean isGfd() {
        return gfd;
    }

    public void setGfd(boolean gfd) {
        this.gfd = gfd;
    }

    public boolean isVdg() {
        return vdg;
    }

    public void setVdg(boolean vdg) {
        this.vdg = vdg;
    }

    public boolean isHmd() {
        return hmd;
    }

    public void setHmd(boolean hmd) {
        this.hmd = hmd;
    }

    public boolean isSfd() {
        return sfd;
    }

    public void setSfd(boolean sfd) {
        this.sfd = sfd;
    }

    public Object getExtras() {
        return extras;
    }

    public void setExtras(Object extras) {
        this.extras = extras;
    }



    @Override
    public  String toString(){

        String resultType = "";
        String resultExtra = "";

        if(enumType == Type.st){
            resultType = "Starter";
            resultExtra = ", Eaten with ";
        } else if (enumType == Type.mc){
            resultType = "Main Course";
            resultExtra = ", Best with ";
        } else if(enumType == Type.ds){
            resultType = "Dessert";
            resultExtra = ", Caloric content ";
        }



        return "Customer: " + customerName + ". Dish: " + dishName + ", Category: "+ resultType
        + ", Gluten-free: "+ gfd+ ", Vegetarian: " + vdg + ", Halal-meat: "
                + hmd + ", Seafood-free: " + sfd + resultExtra + extras+ ".";
    }


}
