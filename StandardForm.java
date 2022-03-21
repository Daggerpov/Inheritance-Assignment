import java.util.Arrays;
import java.util.ArrayList;

public class StandardForm extends Quadratic {
	

	public StandardForm (String equation) {
		super(equation);
	}

	

	// public String convertToVertexForm() {

	// 	return 
	// }

	public String convertToFactoredForm() {
		ArrayList<Double> factors = calculateFactors();
		if (factors.size() == 0){
			System.out.println("This equation cannot be converted to factored form since it has no factors");
		}
		String factoredFormOfEquation = "";
		factoredFormOfEquation.concat(Integer.toString(getAVal()));
		
		factoredFormOfEquation.concat("(x ");
		if (factors.get(0) >= 0){
			factoredFormOfEquation.concat("+ ");
		} else {
			factoredFormOfEquation.concat("- ");
		}
		
		factoredFormOfEquation.concat(Double.toString(factors.get(0))).concat(")");

		factoredFormOfEquation.concat("(x ");
		if (factors.get(1) >= 0) {
			factoredFormOfEquation.concat("+ ");
		} else {
			factoredFormOfEquation.concat("- ");
		}

		factoredFormOfEquation.concat(Double.toString(factors.get(1))).concat(")");

		return factoredFormOfEquation;
	}
	
	
}