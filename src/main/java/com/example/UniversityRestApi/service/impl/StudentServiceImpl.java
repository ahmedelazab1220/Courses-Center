package com.example.UniversityRestApi.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.UniversityRestApi.entity.Course;
import com.example.UniversityRestApi.entity.Student;
import com.example.UniversityRestApi.exc.CourseNotFoundException;
import com.example.UniversityRestApi.exc.StudentNotFoundException;
import com.example.UniversityRestApi.repo.CourseRepository;
import com.example.UniversityRestApi.repo.StudentRepository;
import com.example.UniversityRestApi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);

		Student theStudent;

		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			throw new StudentNotFoundException("Student Not Found!");
		}

		return theStudent;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();

		if (students.isEmpty()) {
			throw new StudentNotFoundException("There's No Students!");
		}

		return students;
	}

	@Override
	public void deleteById(int theId) {

		Optional<Student> result = studentRepository.findById(theId);

		if (result.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found!");
		}

		studentRepository.deleteById(theId);

	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public Student addCoursetoStudent(int studentId, int courseId) {
		List<Course> courses = null;
		Student theStudent = studentRepository.findById(studentId).get();
		Course theCourse = courseRepository.findById(courseId).get();

		if (theStudent == null) {
			throw new StudentNotFoundException("Student Not Found!");
		}

		if (theCourse == null) {
			throw new CourseNotFoundException("Course Not Found!");
		}

		courses = theStudent.getCourses();

		courses.add(theCourse);

		theStudent.setCourses(courses);

		return studentRepository.save(theStudent);
	}

	@Override
	public Student update(int theId, Map<String, Object> fields) {

		Optional<Student> result = studentRepository.findById(theId);

		if (result.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found!");
		}

		Student theStudent = result.get();

		fields.forEach((key, val) -> {
			Field field = ReflectionUtils.findField(Student.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, theStudent, val);
		});

		return studentRepository.save(theStudent);
	}

}
