import java.util.ArrayList;

public class FactoredForm extends Quadratic {
    
    int numOfFactors;
    int sVal;
    int tVal;

    public FactoredForm(String equation) {
        super(equation);
        // this is the factored form's version of the extractVals()
        // function which will also run with the superclass (Quadratic)
        // one named the same thing to get the a value. this one 
        // gets the S and T values in the form of a(x - s)(x - t)
        extractVals();
    }

    private void extractVals() {
        // splitting up the equation based on spaces
        String[] partsOfEquation = equation.split(" ");

        // finding the index of the s value because it's what's until the index of the closing bracket of its term
        int endIndexOfS = partsOfEquation[2].indexOf(")");

        // if it's equal to the last index of the string, then it means that I can't extract the s value
        if (endIndexOfS != -1){
            // grabbing the substring between the start of the s value until the ending bracket using its index
            sVal = Integer.parseInt((partsOfEquation[2]).substring(0, endIndexOfS));
        }

        if (partsOfEquation[1].equals("-")){
            sVal *= -1;
        }

        // same method for finding T value as for S
        int endIndexOfT = partsOfEquation[4].indexOf(")");

        if (endIndexOfT != -1) {

            tVal = Integer.parseInt((partsOfEquation[4]).substring(0, endIndexOfT));
        }

        if (partsOfEquation[3].equals("-")) {
            tVal *= -1;
        }


        // this is done since in factored form, these values are being
        // subtracted from the x for each of the factors, therefore
        // the sign must be flipped
        sVal *= -1; tVal *= -1;
    }

    private static int countMatches(String equation) {
        // this helper method is to count the amount of opening brackets since it indicates
        // the amount of factors
        
        if (equation == "") {
            return 0;
        }

        int index = 0, count = 0;
        while (true) {
            // going through the string and adding one to the count variable for every time the index is of an opening bracket
            index = equation.indexOf("(", index);
            // this will be false if it's at the last index (-1)
            if (index != -1) {
                count++;
                index += "(".length();
            } else {
                break;
            }
        }

        return count;
    }

    public int getNumOfFactors() {
        // this will invoke my method for counting the amount of open brackets 
        // in the user inputted equation, therefore this will equate to the 
        // amount of factors
        return countMatches(equation);
    }

    public ArrayList<Integer> getSAndT() {
        ArrayList<Integer> sAndT = new ArrayList<Integer>();
        sAndT.add(sVal);
        sAndT.add(tVal);
        return sAndT;
    }

    public String convertToStandardForm() {
        // first term of the equation
        String standardFormOfEquation = Integer.toString(getAVal()) + "x^2 ";

        // this is a simplified way to calculate the standard form values 
        // from expanding the factors using FOIL
        int calculatedBVal = getAVal() * (-tVal + -sVal);
        int calculatedCVal = getAVal() * -sVal * -tVal;
        
        // using ternary operator to do same operations as earlier with signs
        standardFormOfEquation += (calculatedBVal >= 0) ? "+ " : "- ";
        standardFormOfEquation += Math.abs(calculatedBVal) + "x ";

        standardFormOfEquation += (calculatedCVal >= 0) ? "+ " : "- ";
        standardFormOfEquation += Math.abs(calculatedCVal);
        return standardFormOfEquation;
    }

    public ArrayList<Double> calculateVertexCoordinates() {
        ArrayList<Double> vertexCoords = new ArrayList<Double>();
        double xOfV = (double)(sVal + tVal)/2;
        vertexCoords.add(xOfV);
        //simply calculating the y value through substitution with this x value of the vertex
        vertexCoords.add(getAVal() * (xOfV - sVal) * (xOfV - tVal));
        return vertexCoords;
    }

    public String convertToVertexForm() {
        String vertexFormOfEquation = Integer.toString(getAVal()) + "(x ";
        Double xOfV = calculateVertexCoordinates().get(0);
        Double yOfV = calculateVertexCoordinates().get(1);

        // it's (x - h) therefore I need to flip the sign by evaluating if it's 
        // below 0 rather than greater/equal to 0
        vertexFormOfEquation += (xOfV < 0) ? "+ " : "- ";
        vertexFormOfEquation += Math.abs(xOfV) + ")^2 ";

        vertexFormOfEquation += (yOfV >= 0) ? "+ " : "- ";
        vertexFormOfEquation += Math.abs(yOfV);
        return vertexFormOfEquation;
    }
}