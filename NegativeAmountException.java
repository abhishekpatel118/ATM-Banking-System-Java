//NegativeAmountException.java 
class NegativeAmountException extends Exception {
	
	NegativeAmountException(){ 
		super();
	}
	
	NegativeAmountException(String errMsg){ 
		super(errMsg); 
	} 

}
