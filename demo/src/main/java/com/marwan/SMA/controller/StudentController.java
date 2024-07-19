package com.marwan.SMA.controller;

import com.marwan.SMA.model.Student;
import com.marwan.SMA.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
@RestController= mark a class as a RESTful web service controller
IT Treats each method in the class as a handler for web requests,
and automatically serializes the return value of each method into JSON
(or another appropriate format) to be sent back as the HTTP response body.
it


@RequestMapping= map HTTP requests to handler methods of MVC and REST controllers.
used in con controller


 */

/*
CRUD REPO
C= Create -->@PostMapping
R=Read -->@GetMapping
U=Update --> @PutMapping
D=Delete --> @DeleteMapping
*/

@RestController
@RequestMapping("/Students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private studentRepository studentRepository;


    @PostMapping
    public Student saveEtudiant(@RequestBody Student student){
        return studentRepository.save(student);
    }
    //lire tout les étudiants
    @GetMapping
    public ResponseEntity<List<Student>> lireToutEtudiants(){
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }
//TIP
// @PathVariable :extract values from the URL path of a request and bind them to method parameters in a controller
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        /*
        !!!!!the next 2 lines explanation!!!!!
        the code will search in studentRepository for the exact id,
        if he finds it, he'll show the infos else a message will appear
         */
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return ResponseEntity.ok(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEtudiant(@PathVariable Long id){
        /*
        !!!!!the next 2 lines explanation!!!!!
        the code will search in studentRepository for the exact id,
        if he finds it, he'll start deleting else a message will appear
         */
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException(("no student to delete with this "+ id)));
        studentRepository.delete(student);
        /*
        the next line explnation
        return an HTTP response indicating that the request was successfully processed
        But there is no content to return.
         */
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    //@RequestBody: bind the HTTP request body to a method parameter.
    //              also to deserialize the JSON (or other formats) in the request body into a Java object.

    //TIP In the context of *updating* a student, the @RequestBody annotation is used because
    // the updated student details are sent in the body of the HTTP request as JSON.
    // This allows the entire student object to be sent and bound to a Student parameter in the method.

    public ResponseEntity<Student>  mettre_a_jour(@PathVariable Long id, @RequestBody Student studentdetails){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException(("no student with this "+ id)));
        //updating student data
        student.setNom(studentdetails.getNom());
        student.setAge(studentdetails.getAge());
        student.setPrenom(studentdetails.getPrenom());
        student.setSchool(studentdetails.getSchool());
        student.setSexe(studentdetails.getSexe());
        student.setAnneeScolaire(studentdetails.getAnneeScolaire());
        Student updatedStudent = studentRepository.save(student);

        // explanation of the last line
        //ResponseEntity.ok(updatedStudent): it ensures that the client receives confirmation that the operation was successful
        // and provides the updated resource for further use or display.
        return ResponseEntity.ok(updatedStudent);


    }


}
