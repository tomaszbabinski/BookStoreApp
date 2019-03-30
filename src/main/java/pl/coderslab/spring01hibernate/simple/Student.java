package pl.coderslab.spring01hibernate.simple;




import java.util.List;


public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private Boolean mailingList;
    private List<String> programmingSkills;
    private List<String> hobbies;

    public Student(String firstName, String lastName, String gender, String country, String notes, Boolean mailingList, List<String> programmingSkills, List<String> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.mailingList = mailingList;
        this.programmingSkills = programmingSkills;
        this.hobbies = hobbies;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", hobbies=" + hobbies +
                '}';
    }
}
