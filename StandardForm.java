import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;

public class StandardForm extends Quadratic {

	public StandardForm(String equation) {
		super(equation);
	}

	public String convertToFactoredForm() {
		ArrayList<Double> factors = calculateFactors();

		String factoredFormOfEquation = "";

		if (factors.get(0).isNaN() == true && factors.get(1).isNaN() == true){
			return "This equation cannot be converted to factored form since it has no factors";
		} else {
			factoredFormOfEquation = Integer.toString(getAVal());
			
			if (factors.get(0).isNaN() == false){
				factoredFormOfEquation += "(x ";
				if (factors.get(0) >= 0){
					factoredFormOfEquation += "- ";
				} else {
					factoredFormOfEquation += "+ ";
				}
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