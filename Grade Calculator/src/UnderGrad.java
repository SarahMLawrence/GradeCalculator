public final class UnderGrad extends Student {
    
    //Declarations
    private float MidTerm;
    private float Final;

    //Default constructor
    public UnderGrad(){
        this("John", "Doe", 99, 99 , 99);    
    }

    //Undergrad Student Overloaded Constructor
    public UnderGrad(String first, String last, int grade, float mid, float fin){
        //Pass values to Student constructor
        super(first, last, grade);
        MidTerm = mid;
        Final = fin;
    }

    //setMidTerm
    public void setMidTerm(float mid){
        MidTerm = mid;
    }//end setMidTerm

    //return MidTerm grade
    public float getMidTerm(){
        return MidTerm;
    }

    //set Final
    public void setFin(float fin){
        Final = fin;
    }

    //get Final
    public float getFin(){
        return Final;
    }

    public float FinalGradeUnderGrad(){
        return(float)((.75 * getAverage()) + (.10 * getMidTerm()) + (.15 * getFin()));
    }

    public float FinalGradeGrad() {
        return (float)((.75 * getAverage()) + (.25 * getFin()));
    }
}//End class UnderGrad 