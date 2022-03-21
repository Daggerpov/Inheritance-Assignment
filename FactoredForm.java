public class FactoredForm extends Quadratic {
    
    public FactoredForm(String equation) {
        super(equation);
        System.out.println(equation);
        extractVals();
    }

    private void extractVals() {
        String aValDigits = "";

        // going through the equation until the first x, which
        // will be to the power of 2 and everything before it will be the
        for (int i = 0; i <= equation.indexOf('('); i++) {
            char currentChar = equation.charAt(i);
            boolean flag = Character.isDigit(currentChar);

            if (flag) {
                aValDigits = aValDigits.concat(Character.toString(currentChar));
            } else if (currentChar == '-') {
                // if there's a negative sign, this means the parabola is facing down,
                // otherwise it's facing up in direction
                directionA = "down";
            }
        }
        aVal = Integer.parseInt(aValDigits);

        if (directionA.equals("down")) {
            aVal *= -1;
        }
    }
}