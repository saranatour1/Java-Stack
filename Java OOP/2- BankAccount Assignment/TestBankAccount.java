
public class TestBankAccount {
	public static void main(String[] args) {

    BankAccount account1 = new BankAccount();

    //display to choose one of the accounts 
    account1.chooseAccount();
    account1.depositMoney(900,1);
    account1.depositMoney(900,2);
    account1.depositMoney(7900,2);
    account1.withdraw(9800, 1);
    System.out.println(account1.balance());



		}
	}
