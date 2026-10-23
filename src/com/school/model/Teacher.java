package  com.school.model; // FIX: Grouped into the same package layout as User and Student

public class Teacher extends User {
    private String subject;

    public Teacher(int id, String name, String email, String subject) {
        super(id, name, email);
        this.subject = subject;
    }

    // FIX: Swapped fully capitalized names (getSUBJECT) for clean standard camelCase
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public void displayDashboard() {
        System.out.println("=== Teacher Dashboard ===");
        System.out.println("Name: " + getName());   // FIX: Changed from getNAME() to match parent class
        System.out.println("Email: " + getEmail()); // FIX: Changed from getEMAIL() to match parent class
        System.out.println("Subject Taught: " + subject); // FIX: Removed duplicate print statements
        System.out.println("-----------------------------");
    }
}
