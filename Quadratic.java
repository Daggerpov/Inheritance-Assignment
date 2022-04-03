import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Quadratic {
	int aVal;
	int bVal;
	int cVal;
	String equation;
	double xOfVertex;

	// direction A is also known as the parabola's overall direction
	String directionA = "up";

	// Constructor to get the equation
	public Quadratic(String eqn) {
		equation = eqn;
		extractVals();
	}

	private void extractVals() {
		String aValDigits = ""; 
		
		// going through the equation until the first x, which
		// will be to the power of 2 and everything before it will be the 
		// a value, and this will work for all forms of parabolic equations
		for (int i = 0; i <= equation.indexOf( 'x' ); i++){
			char currentChar = equation.charAt(i);
			
			// setting a flag to go up if the character value is a digit to be part of the aVal digits
			boolean flag = Character.isDigit(currentChar);
			
			if (flag){
				aValDigits = aValDigits += Character.toString(currentChar);
			} else if (currentChar == '-') {
				// if there's a negative sign, this means the parabola is facing down, 
				//otherwise it's facing up in direction
				directionA = "down";
			}
		}
		aVal = Integer.parseInt(aValDigits);
		
		if (directionA.equals("down")) {
			aVal *= -1;
		}

		try {
			// splitting up the equation from a pivot of the number 2 followed by a space
			// which can only first occur at the '^2 ' part of it, since even if the a value
			// were 2 then it wouldn't be followed by a space, but rather 'x^2'

			// after splitting it up this way, the a value should be on the left, with
			// us being able to retrieve the B and C values from getting the right side
			// (index 1)

			// then, .split(" ") is splitting it into a String Array based on where there's
			// spaces
			String[] bAndC = equation.split("2 ")[1].split(" ");

			// extracting the B value from this Array from looking at the first couple
			// spaced
			// terms, being the sign of it and its value, but making sure to keep the
			// negative
			// and deleting the positive sign since by default the b value is already
			// positive

			// the rest of the .replace() method calls are to format it without the split
			// array's syntax
			bVal = Integer.parseInt(Arrays.toString(Arrays.copyOfRange(bAndC, 0, 2)).replace("[", "").replace("]", "")
					.replace(",", "").replace("+", "").replace(" ", "").replace("x", ""));

			// getting the C value from getting the last term
			cVal = Integer.parseInt(equation.split(" ")[(equation.split(" ").length) - 1]);

			// getting the sign of the C value and modifying it if negative like before for
			// the B value
			if ((equation.split(" ")[(equation.split(" ").length) - 2]).equals("-")) {
				cVal *= -1;
			}
		} catch (Exception e) {
			System.out.println("cannot extract b and c values.");
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
		// simply applying the quadratic formula but either getting the positive
		// square root or the negative version, and storing both since they're separate
		// x
		// resulting values
		double positiveAnswer = (((-bVal) + Math.sqrt(((Math.pow(bVal, 2)) - (4 * aVal * cVal)))) / (2 * aVal));
		double negativeAnswer = (((-bVal - Math.sqrt(((Math.pow(bVal, 2)) - (4 * aVal * cVal))))) / (2 * aVal));

		ArrayList<Double> xValues = new ArrayList<Double>();

		if (Double.isNaN(positiveAnswer) && Double.isNaN(negativeAnswer)) {
			// this occurs when there are no solutions, therefore it was either a
			// parabola facing up with a vertex > 0 or a parabola facing down with
			// its vetex under the x-axis (< 0)
			System.out.println("No solutions for finding x. ");
		} else if (Double.isNaN(negativeAnswer)) {
			// if there is only one solution, then that must mean it's the vertex
			System.out.println("Your only x value that does not say 'NaN' is therefore your vertex. ");
		}

		xValues.add(positiveAnswer);
		xValues.add(negativeAnswer);
		return xValues;
	}

	public ArrayList<Double> calculateFactors() {
		ArrayList<Double> xValues = (useQuadraticFormula(getAVal(), getBVal(), getCVal()));

		ArrayList<Double> factors = new ArrayList<Double>();

		// simply getting both x values from the array using the .get() method
		// which is equivalent to accessing elements by index in a regular array.
		factors.add((double) xValues.get(0));
		factors.add((double) xValues.get(1));

		return factors;
	}

	public ArrayList<Double> calculateRandomXValues(int randomY) {
		// round at the end to int

		// bring everything to one side so that it's equal to 0 and factorable
		// this is bringing the Y value to the other side by subtracting it from
		// the previous C value and then storing that into the new one.
		int newC = getCVal() - randomY;

		ArrayList<Double> xValues = (useQuadraticFormula(getAVal(), getBVal(), newC));

		ArrayList<Double> randomXVals = new ArrayList<Double>();
		randomXVals.add((double) xValues.get(0));
		randomXVals.add((double) xValues.get(1));

		return randomXVals;
	}

	public int calculateRandomYValue(double randomX) {
		// round at the end

		// rather than finding the x of vertex simply with the class
		// variables that I could already retrieve from the getters,
		// in this function, I am accepting an argument for which x value
		// to find it for, so the function must differ slightly in that regard.

		double firstTerm = (Math.pow(randomX, 2) * aVal);
		double secondTerm = (bVal * randomX);
		double thirdTerm = cVal;
		return (int) (firstTerm + secondTerm + thirdTerm);
	}

	public double calculateXOfVertex() {
		// the mathematical formula for finding the x value of the parabola's
		// vertex is -b / 2a so I'm simply computing this

		double numerator = -bVal;

		double denominator = 2 * aVal;

		xOfVertex = Math.round((numerator / denominator));

		return xOfVertex;
	}

	public double calculateYOfVertex() {
		// ax^2
		double firstTerm = (Math.pow(getXOfVertex(), 2) * aVal);

		// bx
		double secondTerm = (bVal * getXOfVertex());

		// c
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