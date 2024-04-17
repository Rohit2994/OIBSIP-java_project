package project;

public class history {
    static void transactionhistory(){
        System.out.println("---------------------");
        System.out.println("Transaction History :");
        int k=0;
        if(Atm.balance>0){
            for(int i=0;i<(Atm.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(Atm.history.get(k)+" ");
                    k++;
                }
                System.out.println("---------------------");
            }
        }
        else {
            System.out.println("your account is empty");
        }
        Atm.prompt();
    }
}
