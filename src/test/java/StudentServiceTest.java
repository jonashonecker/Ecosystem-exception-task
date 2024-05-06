import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentService studentService;
    Student studentId;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        studentId = studentService.addNewStudent(new Student("1", "Otto", "English"));
        studentService.addNewStudent(new Student("1", "Otto", "English"));
        studentService.addNewStudent(new Student("2", "Anna", "France"));
        studentService.addNewStudent(new Student("3", "Jano", "Math"));
        studentService.addNewStudent(new Student("4", "Bila", "Sport"));
    }

    @AfterEach
    void tearDown() {
        studentService = new StudentService();
    }

    @Test
    void findById_whenInvalidId_throwsStudentNotFoundException () {
        Exception myException = assertThrows(StudentNotFoundException.class, () -> studentService.findById("123"));
        System.out.println(myException.getMessage());
    }

    @Test
    void findById_whenValidId_ReturnStudent () throws StudentNotFoundException {
        // GIVEN
        String id = studentId.id();
        Student expected = new Student(id, "Otto", "English");

        // WHEN
        Student actual = studentService.findById(id);

        // THEN
        assertEquals(expected, actual);
    }
}