import java.util.ArrayList;

public class VertexForm extends Quadratic {
	int hVal;
    int kVal;

    public VertexForm(String equation) {
        super(equation);
        // this is the factored form's version of the extractVals()
        // function which will also run with the superclass (Quadratic)
        // one named the same thing to get the a value. this one 
        // gets the S and T values in the form of a(x - s)(x - t)
        extractVals();
    }

    private void extractVals() {
        String[] partsOfEquation = equation.split(" ");

        // same method as what's done in FactoredForm.java

        int endIndexOfS = partsOfEquation[2].indexOf(")");

        if (endIndexOfS != -1) {
            hVal = Integer.parseInt((partsOfEquation[2]).substring(0, endIndexOfS));
        }

        if (partsOfEquation[1].equals("-")) {
            hVal *= -1;
        }

        kVal = Integer.parseInt(partsOfEquation[4]);

        if (partsOfEquation[3].equals("-")) {
            kVal *= -1;
        }

        // this is done since the h val needs its sign flipped from 
        // the equation stating (x - h)
        hVal *= -1;
    }

    public String stateShifts() {
        String shiftStatement = "This parabola has been horizontally shifted ";
        shiftStatement += (hVal >= 0) ? "right" : "left";
        shiftStatement += " by " + Math.abs(hVal) + " units and vertically shifted ";

        shiftStatement += (kVal >= 0) ? "up " : "down"; 
        shiftStatement += Math.abs(kVal) + " units.";
        return shiftStatement;
    }

    public String convertToStandardForm() {
        String standardFormOfEquation = Integer.toString(getAVal()) + "x^2 ";
        
        // simplified mathematical calcluations for B and C vals
        int calculatedBVal = getAVal() * -hVal * 2;
        
        int calculatedCVal = (int)(getAVal() * (Math.pow(-hVal, 2)) + kVal);

        standardFormOfEquation += (calculatedBVal >= 0) ? "+ " : "- ";
        standardFormOfEquation += Math.abs(calculatedBVal) + "x ";

        standardFormOfEquation += (calculatedCVal >= 0) ? "+ " : "- ";
        standardFormOfEquation += Math.abs(calculatedCVal);
        return standardFormOfEquation;
    }

    public ArrayList<Double> calculateFactors() {
        // moving over to left side, dividing by the a value, then square rooting to find x
        Double leftSide = -(double)kVal;
        leftSide /= getAVal();
        System.out.println(leftSide);

        ArrayList<Double> factors = new ArrayList<Double>();

        if (leftSide < 0) {
            System.out.println("No solutions for finding x. ");
            factors.add(null);
            factors.add(null);
            return factors;
        }

        // taking positive/negative versions of the square root result
        double positiveFactor = Math.sqrt(leftSide);
        double negativeFactor = -(Math.sqrt(leftSide));

        positiveFactor -= -kVal;
        negativeFactor -= -kVal;

        // simply getting both x values from the array using the .get() method
        // which is equivalent to accessing elements by index in a regular array.
        factors.add((double) positiveFactor);
        factors.add((double) negativeFactor);

        return factors;
    }

    public String convertToFactoredForm() {
        String factoredFormOfEquation = Integer.toString(getAVal()) + "(x ";
        ArrayList<Double> factors = calculateFactors();

        System.out.println(factors);

        String cannotBeConverted = "This equation cannot be converted to factored form since it has no factors";

        Double sVal; Double tVal;

        try {
            sVal = -(factors.get(0));
        } catch (Exception e) {
            return cannotBeConverted;
        }

        try {
            tVal = -(factors.get(1));
        } catch (Exception e) {
            return cannotBeConverted;
        }
        
        if ((sVal.isNaN() == true) && (tVal.isNaN() == true)){
			return cannotBeConverted;
		} else {
			factoredFormOfEquation = Integer.toString(getAVal());
			
			if (sVal.isNaN() == false){
				factoredFormOfEquation += "(x ";
				
				factoredFormOfEquation += sVal >= 0 ? "- ": "+ ";
				
				factoredFormOfEquation += Double.toString(Math.abs(sVal)) + ")";
			}

			if (tVal.isNaN() == false){
				factoredFormOfEquation += "(x ";
				
                factoredFormOfEquation += tVal >= 0 ? "- " : "+ ";
				
				factoredFormOfEquation += Double.toString(Math.abs(tVal)) + ")";
			}
        }
        return factoredFormOfEquation;
    }
}