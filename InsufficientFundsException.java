//InsufficientFundsException.java 
class InsufficientFundsException extends Exception{
	
	InsufficientFundsException(){ 
		super();
	}

	InsufficientFundsException(String errMsg){ 
		super(errMsg); 
	} 

}
