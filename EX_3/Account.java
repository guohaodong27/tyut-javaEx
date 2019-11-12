/**
 * Account
 */
class Account{
    private int balance;
    
    public void depoist(int money){
        this.balance += money;
    }

    public void withdraw(int money){
        this.balance -= money;
    }

    public int getBalance(){
        return this.balance;
    }

}