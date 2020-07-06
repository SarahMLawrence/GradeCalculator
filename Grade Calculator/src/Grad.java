public final class Grad extends Student {
    // Declarations
    private float Final;

    // Default constructor
    public Grad() {
        this("John", "Doe", 99, 99);
    }

    // Undergrad Student Overloaded Constructor
    public Grad(String first, String last, int grade, float fin) {
        // Pass values to Student Constructor
        super(first, last, grade);
        Final = (fin);
    }// set final

    public void setFin(float fin) {
        Final = fin;
    }

    // get Final
    public float getFin() {
        return Final;
    }
}// End Class Grad