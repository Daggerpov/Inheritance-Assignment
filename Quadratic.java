import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class Quadratic {
	
	int aVal; int bVal; int cVal;
	String equation;
	double xOfVertex;
	String directionA = "up";


	// Constructor to get the equation
	public Quadratic (String eqn) {
		equation = eqn;

		String aValDigits = ""; 
		
		// going through the equation until the first x, which will be to the power of 2 and everything before it will be the 
		for (int i = 0; i <= equation.indexOf( 'x' ); i++){
			char currentChar = equation.charAt(i);
			boolean flag = Character.isDigit(currentChar);
			
			if (flag){
				aValDigits = aValDigits.concat(Character.toString(currentChar));
			} else if (currentChar == '-') {
				// if there's a negative sign, this means the parabola is facing down, otherwise it's facing up in direction
				directionA = "down";
			}
		}
		aVal = Integer.parseInt(aValDigits);
		
		if (directionA.equals("down")) {
			aVal *= -1;
		}
		String [] bAndC = equation.split("2 ")[1].split(" ");
		
		bVal = Integer.parseInt(Arrays.toString(Arrays.copyOfRange(bAndC, 0, 2)).replace("[", "").replace("]", "").replace(",", "").replace("+", "").replace(" ", "").replace("x", ""));
		
		cVal = Integer.parseInt(equation.split(" ")[(equation.split(" ").length)-1]);
		
		if ((equation.split(" ")[(equation.split(" ").length)-2]).equals("-")){
			cVal *= -1;
		}
	}
	
	public int getAVal() {
		return aVal;
	}

	public int getBVal() {
		return bVal;
	}

	public int getCVal() {
		return cVal;
	}
	
	public String getDirection() {
		return directionA;
	}

	public int getXOfVertex() {
		return (int) xOfVertex;
	}

	private ArrayList<Double> useQuadraticFormula(int aVal, int bVal, int cVal) {
		double positiveAnswer = (((-bVal) + Math.sqrt(((Math.pow(bVal, 2)) - (4*aVal*cVal)))) / (2 * aVal));
		double negativeAnswer = (((-bVal - Math.sqrt(((Math.pow(bVal, 2)) - (4*aVal*cVal))))) / (2 * aVal));

		ArrayList<Double> xValues = new ArrayList<Double>();

		if (Double.isNaN(positiveAnswer) && Double.isNaN(negativeAnswer)) {
			System.out.println("No solutions for finding x. ");
		} else if (Double.isNaN(negativeAnswer)) {
			System.out.println("Your only x value that does not say 'NaN' is therefore your vertex. ");
		}
		
		xValues.add(positiveAnswer);
		xValues.add(negativeAnswer);
		return xValues;
	}

	public ArrayList<Double> calculateFactors() {
		ArrayList<Double> xValues = (useQuadraticFormula(getAVal(), getBVal(), getCVal()));
		
		ArrayList<Double> factors = new ArrayList<Double>();

		factors.add((double)xValues.get(0));
		factors.add((double)xValues.get(1));
		
		return factors;
	}

	public ArrayList<Double> calculateRandomXValues(int randomY) {
		//round at the end to int

		//bring everything to one side so that it's equal to 0 and factorable
		int newC = getCVal() - randomY;

		ArrayList<Double> xValues = (useQuadraticFormula(getAVal(), getBVal(), newC));
		
		ArrayList<Double> randomXVals = new ArrayList<Double>();
		randomXVals.add((double)xValues.get(0));
		randomXVals.add((double)xValues.get(1));

		return randomXVals;
	}

	public int calculateRandomY(double randomX) {
		//round at the end
		double firstTerm = (Math.pow(randomX, 2)*aVal);
		double secondTerm = (bVal * randomX);
		double thirdTerm = cVal;
		return (int)(firstTerm + secondTerm + thirdTerm);		
	}

	public double calculateXOfVertex() {
		double numerator = -bVal;
		
		double denominator = 2 * aVal;

		xOfVertex = Math.round((numerator / denominator));

		return xOfVertex;
	}

	public double calculateYOfVertex() {
		double firstTerm = (Math.pow(getXOfVertex(), 2)*aVal);
		double secondTerm = (bVal * getXOfVertex());
		double thirdTerm = cVal;
		return firstTerm + secondTerm + thirdTerm;		
	}

	public ArrayList<Double> calculateVertexCoordinates() {
		double xOfV = calculateXOfVertex();
		double yOfV = calculateYOfVertex();

		ArrayList<Double> coords = new ArrayList<Double>();
		coords.add(xOfV);
		coords.add(yOfV);
		return coords;
	}

	public int calculateYIntercept() {
		return cVal;
	}
}