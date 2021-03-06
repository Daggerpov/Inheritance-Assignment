import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    
	
	Quadratic myParabola = new Quadratic("-3x^2 - 5x + 7");

	// testing various methods of this standard form equation (my base form 
	// for this superclass)
	System.out.println("x values at y = 5:" + myParabola.calculateRandomXValues(5));
	System.out.printf("y value at x = 2: %d\n", myParabola.calculateRandomYValue(2));
	System.out.println("factors: " + myParabola.calculateFactors());
	
		

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
				sc.nextLine();
				String standardFormInput = sc.nextLine();

				StandardForm standardy = new StandardForm(standardFormInput);

				// testing the remaining standard form methods
				System.out.println("x of vertex: " + standardy.calculateXOfVertex());
				System.out.println("y of vertex: " + standardy.calculateYOfVertex());
				System.out.println("vertex coordinates: " + standardy.calculateVertexCoordinates());
				System.out.println("y-intercept: " + standardy.calculateYIntercept());
				System.out.println("factored form conversion of this parabola's equation: " + standardy.convertToFactoredForm());
				System.out.println(
						"vertex form conversion of this parabola's equation: " + standardy.convertToVertexForm());
				break;
			case 2:
				System.out.print("Enter the equation in the format a(x - s)(x - t): ");
				sc.nextLine();
				String factoredFormInput = sc.nextLine();
				FactoredForm factory = new FactoredForm(factoredFormInput);

				System.out.println("number of factors: " + factory.getNumOfFactors());
				System.out.println(
						"standard form conversion of this parabola's equation: " + factory.convertToStandardForm());
				System.out.println(
						"vertex form conversion of this parabola's equation: " + factory.convertToVertexForm());
				break;
			case 3:
				System.out.print("Enter the equation in the format a(x - h)^2 + k: ");
				sc.nextLine();
				String vertexFormInput = sc.nextLine();
				VertexForm vertexy = new VertexForm(vertexFormInput);
				System.out.println(vertexy.stateShifts());
				System.out.println(
						"standard form conversion of this parabola's equation: " + vertexy.convertToStandardForm());
				System.out.println(
						"factored form conversion of this parabola's equation: " + vertexy.convertToFactoredForm());
				
				break;
		}
	}
	sc.close();
  }
}