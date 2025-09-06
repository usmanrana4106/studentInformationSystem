package com.alasala.sis.studentInformationSystem.service.impl;

import com.alasala.sis.studentInformationSystem.dto.AddStudentDto;
import com.alasala.sis.studentInformationSystem.dto.GetStudentDto;
import com.alasala.sis.studentInformationSystem.entity.Student;
import com.alasala.sis.studentInformationSystem.exception.AlreadyExistRecordException;
import com.alasala.sis.studentInformationSystem.repository.StudentRepository;
import com.alasala.sis.studentInformationSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public GetStudentDto getStudentByID(String studentId) {
        Student student = studentRepository.getByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
        GetStudentDto getStudentDto = modelMapper.map(student, GetStudentDto.class);
        return getStudentDto;
    }

    @Override
    public List<GetStudentDto> getStudentsList() {
        List<Student> students = studentRepository.findAll();
//        new GetStudentDto(
//                student.getId(),
//                student.getStudentId(),
//                student.getGenderId(),
//                student.getName(),
//                student.getMobile(),
//                student.getCnic(),
//                student.getAge(),
//                student.getDobYear()
//        )
        return students.stream().map(student ->modelMapper.map(student, GetStudentDto.class)).toList();
    }

    @Override
    public GetStudentDto addStudent(AddStudentDto addStudentDto) {
        Student student = studentRepository.getByStudentId(addStudentDto.getStudentId());
        if (student != null) {
            throw new AlreadyExistRecordException("Student Already Exists");
        }
        Student newStudent = modelMapper.map(addStudentDto, Student.class);
        Student addStudent = studentRepository.save(newStudent);
        return modelMapper.map(addStudent, GetStudentDto.class);
    }

    @Override
    public boolean deleteStudent(String studentId) {
       int count = studentRepository.deleteByStudentId(studentId);
       if (count == 0)
           throw new RuntimeException("StudentID : "+studentId+" is not existed in records");
       return true;
    }

    @Override
    public GetStudentDto updateStudent(String studentId, AddStudentDto addStudentDto) {
        Student student = studentRepository.getByStudentId(studentId);
        if (student == null)
            throw new RuntimeException("StudentID : "+studentId+" is not existed in records");
        modelMapper.map(addStudentDto, student);
        Student updateStudent = studentRepository.save(student);
        return modelMapper.map(updateStudent, GetStudentDto.class);
    }

    @Override
    public GetStudentDto patchStudent(String studentId, AddStudentDto addStudentDto) {
        Student student = studentRepository.getByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("StudentID : " + studentId + " does not exist");
        }

        if (addStudentDto.getName() != null) {
            student.setName(addStudentDto.getName());
        }
        if (addStudentDto.getAge() != 0) {
            student.setAge(addStudentDto.getAge());
        }
        if (addStudentDto.getCnic() != null) {
            student.setCnic(addStudentDto.getCnic());
        }
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, GetStudentDto.class);
    }
}
