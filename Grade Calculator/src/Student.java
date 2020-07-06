import java.util.ArrayList;
import java.util.List;

//---------------------//
// Begin Student Class //
//---------------------//
public abstract class Student {
    // Declarations
    private String firstName;
    private String lastName;
    private float aGrade;

    // Array list to hold grades
    List<Float> Grades = new ArrayList<>();

    // three-argument constructor
    public Student(String first, String last, float grade) {
        firstName = first;
        lastName = last;
        aGrade = grade;// stores the grades
    }// end 3 argument constructor

    // set first name
    public void setFirstName(String first) {
        firstName = first; // should validate
    }// end method setFirstName

    // return first name
    public String getFirstName() {
        return firstName;
    }// end method getFirstName

    // set last name
    public void setLastName(String last) {
        lastName = last; // should validate
    }// end method setLastName

    // return last name
    public String getLastName() {
        return lastName;
    }// end method getLastName

    // set student grade
    public void setStudentGrade(float grade) {
        // Add grades to list
        Grades.add(grade);
        aGrade = grade;
    }

    // get average grade
    public float getAverage() {
        float avg = 0.0f;
        for (Float grd : Grades) {
            avg += grd;
            aGrade = (float) (avg / Grades.size());
        }

        return aGrade;
    }

}// End Class Student