import java.util.ArrayList;
import java.lang.Math;

public class StandardForm extends Quadratic {

	public StandardForm(String equation) {
		super(equation);
	}

	public String convertToFactoredForm() {
		ArrayList<Double> factors = calculateFactors();

		String factoredFormOfEquation = "";

		// if the numbers are invalid, that means I can't use them as factors
		if (factors.get(0).isNaN() == true && factors.get(1).isNaN() == true){
			return "This equation cannot be converted to factored form since it has no factors";
		} else {
			// starting to bulid out the equation string with the a value since it's at the start
			factoredFormOfEquation = Integer.toString(getAVal());
			
			// if there is an invalid factor then it won't be considered
			// otherwise, it will be included as a factor and the sign is inversed
			// due to the (x - s) and (x - t) format

			if (factors.get(0).isNaN() == false){
				factoredFormOfEquation += "(x ";
				if (factors.get(0) >= 0){
					factoredFormOfEquation += "- ";
				} else {
					factoredFormOfEquation += "+ ";
				}
				// after flipping its sign, I then append the absolute value since I've
				// already added the sign
				factoredFormOfEquation += Double.toString(Math.abs(factors.get(0))) + ")";
			}

			if (factors.get(1).isNaN() == false){
				factoredFormOfEquation += "(x ";
				if (factors.get(1) >= 0) {
					factoredFormOfEquation += "- ";
				} else {
					factoredFormOfEquation += "+ ";
				}

				factoredFormOfEquation += Double.toString(Math.abs(factors.get(1))) + ")";
			}
			return factoredFormOfEquation;
		}
	}

	public String convertToVertexForm() {
		ArrayList<Double> vertexCoords = calculateVertexCoordinates();

		String vertexFormOfEquation = Integer.toString(getAVal());
		vertexFormOfEquation += "(x ";
		if (vertexCoords.get(0) >= 0) {
			vertexFormOfEquation += "- ";
		} else {
			vertexFormOfEquation += "+ ";
		}
		vertexFormOfEquation += Double.toString(Math.abs(vertexCoords.get(0))) + ")^2 ";

		
		if (vertexCoords.get(1) >= 0) {
			vertexFormOfEquation += "- ";
		} else {
			vertexFormOfEquation += "+ ";
		}

		vertexFormOfEquation += Double.toString(Math.abs(vertexCoords.get(1)));
		
		return vertexFormOfEquation;
	}
}