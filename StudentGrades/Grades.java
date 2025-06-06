public class Grades {

    private int totalGradePoints;
    private int numberOfGrades;

    // Constructor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Grades() {
        totalGradePoints = 0;
        numberOfGrades = 0;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public Grades(int pointsIn, int countIn) {
        totalGradePoints = pointsIn;
        numberOfGrades = countIn;
    }

    // Accessor
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int totalGradePoints() {
        return totalGradePoints;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public int numberOfGrades() {
        return numberOfGrades;
    }

    // Mutator
    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void totalGradePoints(int TGP) {
        totalGradePoints = TGP;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public void numberOfGrades(int NOG) {
        numberOfGrades = NOG;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public double calculateAverage() {
        return totalGradePoints / (numberOfGrades * 1.0);
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    public char assignLetterGrade() {
        double average = calculateAverage();
        char retLetterGrade;

        if (average >= 90)
            retLetterGrade = 'A';
        else if (average >= 80)
            retLetterGrade = 'B';
        else if (average >= 70)
            retLetterGrade = 'C';
        else if (average >= 60)
            retLetterGrade = 'D';
        else
            retLetterGrade = 'F';

        return retLetterGrade;
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
}