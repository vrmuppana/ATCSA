package StudentGradeMaps;

public class Student implements Comparable<Student> {

    private final String firstName;
    private final String lastName;
    int id;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        if (lastName.compareTo(o.lastName) != 0)
            return lastName.compareTo(o.lastName);
        if (firstName.compareTo(o.firstName) != 0)
            return firstName.compareTo(o.firstName);
        return Math.max(id, o.id);
    }


    public String toString() {
        return firstName + " " + lastName;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Student))
            return false;
        Student st = (Student) o;
        if (st == this)
            return true;
        return (st.firstName.equals(this.firstName) && st.lastName.equals(this.lastName) && st.id == this.id);
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
}
