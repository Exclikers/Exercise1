import java.util.Scanner;
import java.util.Random;

public class FirstProgram {

		private static int row = 0;
	    private static int col = 0;
	    private static String[][] numbers;
	    private static int index1, index2;
	    private static boolean isNumber;
	    private static Scanner dimension = new Scanner(System.in);
	    private static int inrow = 0;
		private static int incol = 0;
		private static String ascii;
		private static String alphabet;


	public static void main(String[] args) {

	 	progStart();
	  	
	}

			static void progStart() {
			  	
			  		userInput();
			  		generateASCII();
			  	
				  	int loop = 1 ;
				  	while (loop > 0) {

						  	System.out.println("\n");
						  	System.out.println("What do you want to do?");
						  	System.out.println("1. Search");
						  	System.out.println("2. Edit");
						  	System.out.println("3. Print");
						  	System.out.println("4. Reset");
						  	System.out.println("5. Exit");
							System.out.print("\n");
						  	
							int select = 0;

						  	do {
						    	System.out.print("Please Select an Option: ");
						    	if (dimension.hasNextInt()) {
						    		select = dimension.nextInt();
						    		isNumber = true;
						    	} else {
						    		System.out.println("Please Input a valid number!");
						    		isNumber = false;
						    		dimension.next();
						    	}
						    } while (!(isNumber));

						    System.out.print("\n");

						    if (select == 1) {
						    	menuSearch();
						    }

						    if (select == 2) {
						    	menuEdit();
						    }

						  	if (select == 3) {
						    	menuPrint();
						    }

						    if (select == 4) {
						    	progStart();
						    }

						    if (select == 5) {
						    	menuExit();
						    }

						    if (select > 5){
						    	System.out.print("Please Select only from 1 - 5");
						    }
						  
				 	}  	
			 
			}

			static void userInput(){
				    do {
				    		System.out.print("Enter Number of Row: ");
					    	if (dimension.hasNextInt()) {
					    		row = dimension.nextInt();
					    		inrow = row;
					    		isNumber = true;
					    	} else {
					    		System.out.println("Please Input a valid number!");
					    		isNumber = false;
					    		dimension.next();
					    	}

					    	if ((inrow > 1000) || (inrow < 1)) {
						    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
						    	isNumber = false;
					    	}
			    	} while (!(isNumber));


				    do {
					    	System.out.print("Enter Number of Column: ");
					    	if (dimension.hasNextInt()) {
					    		col = dimension.nextInt();
					    		incol = col;
					    		isNumber = true;
					    	} else {
					    		System.out.println("Please Input a valid number!");
					    		isNumber = false;
					    		dimension.next();
					    	}
					    	if ((incol > 1000) || (incol < 1)) {
						    	System.out.println("Not allowed! Please Select from 1 - 1000 \n");
						    	isNumber = false;
					   		}
				    } while (!(isNumber));
			}

			static void generateASCII(){

					numbers = new String[row][col];

				  	for(index1 = 1 ; index1 <= row ; index1++) {
				  		for(index2 = 1 ; index2 <= col ; index2++) {
				  			
				  			StringBuilder as = new StringBuilder();

				  			for (int c = 32 ; c <= 127 ; c++) {
									ascii = String.format("%c",c);
									as.append(ascii);
								}
							
				  			alphabet = as.toString();
							StringBuilder sb = new StringBuilder();
				  			Random random = new Random();

						  	for (int i = 0 ; i < 3 ; i++) {
						  		int index = random.nextInt(alphabet.length());
						  		char randomChar = alphabet.charAt(index);
						  		sb.append(randomChar);
						  	}
						  	String randomString = sb.toString();
				  			numbers[index1-1][index2-1] = randomString;
				  		}
			  		}

				  	System.out.println("\n");
				  	System.out.println("You Successfully created a table");
			}

			static void menuSearch() {
			  		Scanner mySearch = new Scanner(System.in);
			    	System.out.print("\n");
			    	System.out.print("Search an index: ");
			   		String search = mySearch.nextLine();

			   		int occurence = 0;
			   		int found = 0;
			   		int x = 0;
			   		int y = 0;
			   		int roccur = 0;
			   		
			   		for(index1 = 1 ; index1 <= row ; index1++) {
				  		for(index2 = 1; index2 <= col ; index2++) {
				  			String searchResult = numbers[index1-1][index2-1];

				  			if(searchResult.equals(search)) {
				  				occurence = occurence +1;
				  				found = 1;
				  				x=index1;
				  				y=index2;
				  				roccur=occurence;
				  			}		
				  			occurence = occurence +1;
				  		}

			  		}
			  				switch (found) {
				  				case 1:
				  					System.out.print("\n");
					  				System.out.println("ELEMENT FOUND!");
					  				System.out.print("\n");
								  	System.out.println(search + " is found at row " + (x) + " and column " + (y) );
								  	System.out.println("Number of occurence = " + roccur);
								  	break;
								default:
									System.out.print("\n");
									System.out.println("ELEMENT NOT FOUND!");
									break;

				  			}
				}

				static void menuEdit() {
						    	int erow = 0;
						    	int ecol = 0;

						   		do {
						    		System.out.print("Enter Row index : ");
							    	if (dimension.hasNextInt()) {
							    		erow = dimension.nextInt();
							    		inrow = erow;
							    		isNumber = true;
							    	} else {
							    		System.out.println("Please Input a valid number!");
							    		isNumber = false;
							    		dimension.next();
							    	}
							    	if ((inrow > 1000) || (inrow < 1)) {
							    		System.out.println("Not allowed! Please Select from 1 - 1000 \n");
							    		isNumber = false;
						    		}
						    	} while (!(isNumber));

						    	
						    	do {
						    		System.out.print("Enter Column index : ");
							    	if (dimension.hasNextInt()) {
							    		ecol = dimension.nextInt();
							    		incol = ecol;
							    		isNumber = true;
							    	} else {
							    		System.out.println("Please Input a valid number!");
							    		isNumber = false;
							    		dimension.next();
						    		}
							    	if ((incol > 1000) || (incol < 1)) {
							    		System.out.println("Not allowed! Please Select from 1 - 1000 \n");
							    		isNumber = false;
							    	}
						    	} while (!(isNumber));


						    	if ((inrow > row) || (incol > col)) {
						    		System.out.println("Table out of bounds. Please Enter between " + (row) + " and " + (col));
						    	} else {

							    	System.out.print("\n");
							    	System.out.println("The Value of the index is : " + numbers[inrow-1][incol-1]);

							    	System.out.print("\n");
							    	Scanner edi2 = new Scanner(System.in);
							    	System.out.print("Enter new value of index " + inrow + " and " + incol + " : ");
							    	String edited = edi2.nextLine();

							    	int caps = edited.length();
							    	int checker = edited.charAt(0);
							    	int checked = 0;

								    	if (caps <= 3) {
								    			for (int q = 0 ; q < alphabet.length() ; q++) {
										    		int ch1 = alphabet.charAt(q);
										    		if (checker == ch1) {
										    			checked = 1;	
										    		} 			
									    		}
									    } 

							   		switch (checked) {
							    		case 1:
							    				numbers[inrow-1][incol-1] = edited;
										    	System.out.print("\n");
										    	System.out.println("Table has been Successfully Edited");
										    	System.out.println("The new value is : " + numbers[inrow-1][incol-1]);
										    	break;
										default:
												System.out.println("\nPlease Input a Valid ASCII Characters");
												break;
							    	}
		    	
						    	}
				}

				static void menuPrint() {
					  		for(index1=1 ; index1 <= row ; index1++) {
						  		for(index2 = 1; index2 <= col ; index2++) {
					  				System.out.print(numbers[index1-1][index2-1] + "\t");		
					  			}
					  			System.out.print("\n");
					  		}
				}

				static void menuExit() {
					  		System.out.println("Thank you for using our Software!");
					    	System.exit(0);
				}
}









