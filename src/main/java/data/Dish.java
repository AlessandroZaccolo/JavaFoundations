package data;


public abstract class Dish {

    public enum Type { st, mc, ds}

    protected String dishName;
    public MyDish.Type enumType;
    protected String type;
    protected boolean gfd;
    protected boolean vdg;
    protected boolean hmd;
    protected boolean sfd;
    protected Object extras;

    public Dish() { }

    public Dish(String dishName, String type, boolean gfd, boolean vdg, boolean hmd, boolean sfd, Object extras) {
        this.dishName = dishName;
        this.type = type;
        this.gfd = gfd;
        this.vdg = vdg;
        this.hmd = hmd;
        this.sfd = sfd;
        this.extras = extras;
    }



    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public MyDish.Type getEnumType() {
        return enumType;
    }

    public void setEnumType(MyDish.Type enumType) {
        this.enumType = enumType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        if(enumType == MyDish.Type.st){
            resultType = "Starter";
            resultExtra = ", Eaten with ";
        } else if (enumType == MyDish.Type.mc){
            resultType = "Main Course";
            resultExtra = ", Best with ";
        } else if(enumType == MyDish.Type.ds){
            resultType = "Dessert";
            resultExtra = ", Caloric content ";
        }



        return "Dish: " + dishName + ", Category: "+ resultType
                + ", Gluten-free: "+ gfd+ ", Vegetarian: " + vdg + ", Halal-meat: "
                + hmd + ", Seafood-free: " + sfd + resultExtra + extras+ ".";
    }
}
