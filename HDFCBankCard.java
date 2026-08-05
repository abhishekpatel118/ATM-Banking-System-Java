//HDFCBankCard.java (Sub type with Inh, Enc, Poly with throwing exceptions)
public class HDFCBankCard implements ATMCard {

	private double balance;

	@Override
	public void deposit(double amt)
					throws NegativeAmountException{
		
		if(amt <= 0)
			throw new NegativeAmountException(
								"Donot pass -ve num or zero ");
		
		balance = balance + amt;
		System.out.println(amt + " is credited to HDFCBank");
	}
	
	@Override
	public void withdraw(double amt)
							throws NegativeAmountException,
									InsufficientFundsException{
		
		if(amt <= 0)
			throw new NegativeAmountException(
								"Do not pass -ve num or zero");	
		
		if(amt > balance)
			throw new InsufficientFundsException(
								"Insufficient Funds");
		
		balance = balance - amt;
		System.out.println(amt + " is debited from HDFCBank");
	}

	@Override
	public void currentBalance(){
		System.out.println("HDFCBank account balance: "+ balance);
	}

}

