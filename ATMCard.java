//ATMCard.java (Super type with Abstraction with declaring exceptions)
interface ATMCard {

	void deposit(double amt) 
				  throws NegativeAmountException;

	void withdraw(double amt)
					throws NegativeAmountException,
						   InsufficientFundsException;

	void currentBalance();

}
