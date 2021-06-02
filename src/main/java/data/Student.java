package data;

public class Student {
    private String prename;
    private String surname;
    private CourseName course;
    private int matriculationNumber;

    public Student(String prename, String surname, CourseName course, int matriculationNumber) {
        super();
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "[prename=" + prename + ", surname=" + surname + ", course=" + course + ", matriculationNumber="
                + matriculationNumber + "]";
    }
    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CourseName getCourse() {
        return course;
    }

    public void setCourse(CourseName course) {
        this.course = course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }


}
