import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public Student findById(String id) throws StudentNotFoundException {
        Optional<Student> optionalStudent = repo.findStudentById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new StudentNotFoundException("Der Student mit der id " + id + " konnte nicht gefunden werden!");
        }
    }

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }
}
