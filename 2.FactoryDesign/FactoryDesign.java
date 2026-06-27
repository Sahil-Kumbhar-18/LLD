abstract class Burger{
    public void orderBurger() {
    }
}

class basicBurger extends Burger{
    public void orderBurger(){
        System.out.println(" This is Basic Burger ");
    }
}

class premiumBurger extends Burger{
    public void orderBurger(){
        System.out.println(" This is Premium Burger ");
    }
}
class WheatbasicBurger extends Burger{
    public void orderBurger(){
        System.out.println(" This is Wheat Basic Burger ");
    }
}

class WheatpremiumBurger extends Burger{
    public void orderBurger(){
        System.out.println(" This is Wheat Premium Burger ");
    }
}

abstract class Garlic{
     public void orderGarlic(){}
}

class basicGarlic extends Garlic{
    public void orderGarlic(){
        System.out.println("This is Basic Garlic ");
    }
}

class premiumGarlic extends Garlic{
    public void orderGarlic(){
         System.out.println("This is Premium Garlic");
    }
}

class WheatbasicGarlic extends Garlic{
    public void orderGarlic(){
        System.out.println("This is Wheat Basic Garlic ");
    }
}

class WheatpremiumGarlic extends Garlic{
    public void orderGarlic(){
         System.out.println("This is Wheat Premium Garlic");
    }
}
interface MainFactory{
    public void createBurger(String str);
    public void createGarlic(String str);
}

class NormalShop implements MainFactory{
    Burger b;
    @Override
    public void createBurger(String str) {
        if(str.equals("Basic")){
           b=new basicBurger();
           b.orderBurger();
        }else if(str.equals("Premium")){
           b=new premiumBurger();
           b.orderBurger();
        }else{
            System.out.println("Invalid Order");
        }
    }
    Garlic g;
    @Override
    public void createGarlic(String str) {
        if(str.equals("Basic")){
            g=new basicGarlic();
            g.orderGarlic();
        }else if(str.equals("Premium")){
            g=new premiumGarlic();
            g.orderGarlic();
        }else{
            System.out.println("Invalid Order");
        }
    }
}

class WheatShop implements MainFactory{
    Burger b;
    @Override
    public void createBurger(String str) {
        if(str.equals("Basic")){
            b=new WheatbasicBurger();
            b.orderBurger();;
        }else if(str.equals("Premium")){
            b=new WheatpremiumBurger();
            b.orderBurger();
        }
    }
    Garlic g;
    @Override
    public void createGarlic(String str) {
       if(str.equals("Basic")){
          g=new WheatbasicGarlic();
          g.orderGarlic();
       }else if(str.equals("Premium")){
        g=new WheatpremiumGarlic();
        g.orderGarlic();
       }
        
    }

}
public class FactoryDesign{
    public static void main(String[] args) {
        MainFactory order=new NormalShop();
        order.createBurger("Basic");
        order.createGarlic("Premium");
        order=new WheatShop();
        order.createBurger("Premium");
    }
}