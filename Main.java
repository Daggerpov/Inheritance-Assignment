class Main {
  public static void main(String[] args) {
    Quadratic myParabola = new Quadratic("-3x^2 - 5x - 7");
	System.out.println(myParabola.calculateVertexCoordinates());
	System.out.println(myParabola.calculateFactors());
	StandardForm standardy = new StandardForm("6x^2 - 8 + 12");
	System.out.println(standardy.calculateRandomXValues(20));
  }
}