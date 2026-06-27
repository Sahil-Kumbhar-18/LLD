class SingeltonDesign{
    public static volatile SingeltonDesign obj=null;
    private SingeltonDesign(){
        System.out.println("Singelton class Object created ");
    }
     public static SingeltonDesign getSingelton(){
        if(obj==null){
           synchronized(SingeltonDesign.class){
             if(obj==null){
                obj = new SingeltonDesign();
             }
           }
        }
        return obj;
    }
}

public class Singelton{
    public static void main(String[] args) {
        SingeltonDesign obj1=SingeltonDesign.getSingelton();
        SingeltonDesign obj2=SingeltonDesign.getSingelton();
        if(obj1==obj2){
            System.out.println(true);
        }else{
            System.out.println("Different Object");
        }
    }
}