import javax.management.InstanceNotFoundException;

public class StudentNotFoundException extends InstanceNotFoundException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
