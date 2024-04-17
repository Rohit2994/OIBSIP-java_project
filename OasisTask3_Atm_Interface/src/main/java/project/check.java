package project;

public class check {
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        Atm.showbalance();
        System.out.println("---------------------------");
        Atm.prompt();
    }
}
