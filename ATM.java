//ATM.java (user class with MP, LC and RP) 
import java.util.Scanner;
import java.util.InputMismatchException;

class ATM {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		while(true) {
			System.out.print("\nInsert Card: ");
			String cardName = scn.nextLine();
			
			try{
				//Reflection API for Loading and instantiating given class
				Class	cls = Class.forName(cardName);			
				Object	obj = cls.newInstance();

				if(!(obj instanceof ATMCard)){
					System.out.println("Error: Invalid card");
					continue; //sending control to beginning of the loop
				}

				System.out.println(cardName + " class is loaded and instantiated");	
						
				ATMCard card = (ATMCard)obj;
				System.out.println("Card reading is completed successfully");
				System.out.println("Start transactions");

				optionsloop:while(true) {
					System.out.println("\nChoose one option: ");
					System.out.println(" 1. Deposit");
					System.out.println(" 2. Withdraw");
					System.out.println(" 3. Balance Enquiry");
					System.out.println(" 4. Exit");

					System.out.print("Enter option number: ");
					int option = scn.nextInt(); scn.nextLine();

					switch(option){
						case 1: {
								while(true) {
									try{
										System.out.print("\nEnter amount to deposit: ");
										double amt = scn.nextDouble(); 	scn.nextLine();

										card.deposit(amt);
										break;
									}catch(InputMismatchException e){
										System.out.println("Error: Enter only number");
										scn.nextLine();
									}catch(NegativeAmountException e){
										System.out.println("Error: "+e.getMessage());
									}
								}//while close
								break  ;
						}//case 1 close

						case 2:{
								while(true){
									try{
										System.out.print("\nEnter amount to withdraw: ");	
										double amt = scn.nextDouble(); scn.nextLine();
										
										card.withdraw(amt);
										break;
									}catch(InputMismatchException e){
										System.out.println("Error: Enter only number");
										scn.nextLine();
									}catch(NegativeAmountException e){
										System.out.println("Error: "+e.getMessage());
									}catch(InsufficientFundsException e){
										System.out.println("Error: "+e.getMessage());
										break;  //breaking loop and switch, because no balance
									}			//to withdraw, then we must display options to 
										  //deposit then withdraw
								}//while close

								break  ;
						}//case 2 close

						case 3:{
							card.currentBalance();
							break  ;
						}//case 3 close

						case 4:{
							System.out.println(" \n******** Thank you :-), Take card ********");
							break optionsloop;    //breaking outer loop and allowing another customer 
						}//case 3 close				//to insert card to do transaction

						default:{
							System.out.println("Invalid option, choose correct option");
						}

					}//switch close
				
				}//options inner while(true) close

			}//outer try close
			catch (ClassNotFoundException e){
				System.out.println("Error: "+ cardName + ".class file is not available");
				System.out.println("Error: "+ e.toString());
				
			}
			catch(NoClassDefFoundError e){
				System.out.println("Error: \""+cardName + "\" spelling is not matched with the class name in "+ cardName + ".class file");
				System.out.println("Error: "+ e.toString());
			}
			catch (InstantiationException e){
				System.out.println(cardName + " class does not contain no-param constructor");
			}catch (IllegalAccessException e){
				System.out.println(cardName + " class does not contain visible no-param constructor");
			}
		
		}//outer while loop close
		
	}//main close
}//class close

/*

- Save all above 8 Java files in a single folder
- Compile all 8 Java file separately
- Execute ATM class, then when prompted pass ATMCard implementation class name

	cmd>javac *.java
	cmd>java ATM
	Insert card name: HDFCBankCard
		----
		----  output
		----
		----
		---- exit

	Insert card name: ICICIBankCard
		----
		----  output
		----
		---- 
		---- exit

	Insert card name: SBIBankCard
		----
		----  output
		----
		---- 
		---- exit
		
	Insert card name: 	
*/