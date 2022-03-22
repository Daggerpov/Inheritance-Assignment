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
        String[] partsOfEquation = equation.split(" ");
        
        int endIndexOfS = partsOfEquation[2].indexOf(")");

        if (endIndexOfS != -1){

            sVal = Integer.parseInt((partsOfEquation[2]).substring(0, endIndexOfS));
        }

        if (partsOfEquation[1].equals("-")){
            sVal *= -1;
        }

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
        if (equation == "") {
            return 0;
        }

        int index = 0, count = 0;
        while (true) {
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

    // public ArrayList<Double> getSAndT() {
        
    // }

    // public String convertToStandardForm() {
    //     String standardFormOfEquation = Integer.toString(getAVal());
    //     // int calculatedBVal = getAVal() *  

    //     // multiplying by 10 until there are no more decimal points remaining
    //     // this is because of a requirement to standard form being that 
    //     // decimals are not permitted
    // }

    // public String convertToVertexForm() {

    // }
}