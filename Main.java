import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    
	
	Quadratic myParabola = new Quadratic("-3x^2 - 5x - 7");

	// testing various methods of this standard form equation (my base form 
	// for this superclass)
	System.out.println(myParabola.calculateRandomXValues(5));
	System.out.println(myParabola.calculateRandomYValue(2));
	System.out.println(myParabola.calculateFactors());
	
		

	Scanner sc = new Scanner(System.in);
	boolean exit = false;

	while (!exit){
		System.out.println("Which equation form would you like to enter? Type 0 to quit.");
		System.out.println("1. Standard\n2. Factored\n3. Vertex");
		int form = sc.nextInt();

		if (form == 0){
			exit = true;
			break;
		}

		

		switch(form){
			case 1:
				System.out.println("Enter the equation in the format ax^2 + bx + c:");
				String standardFormInput = sc.nextLine();
				System.out.println(standardFormInput);
				StandardForm standardy = new StandardForm(standardFormInput);
				// testing the remaining standard form methods
				System.out.println(standardy.calculateXOfVertex());
				System.out.println(standardy.calculateYOfVertex());
				System.out.println(standardy.calculateVertexCoordinates());
				System.out.println(standardy.calculateYIntercept());

				System.out.println(standardy.convertToFactoredForm());

				break;
			case 2:
				System.out.print("Enter the equation in the format a(x - s)(x - t): ");
				String factoredFormInput = sc.next();
				FactoredForm factory = new FactoredForm(factoredFormInput);
				break;
			// case 3:
			// 	VertexForm vertexy = new VertexForm(equationInput);
			// 	break;
		}
	}
	sc.close();
  }
}