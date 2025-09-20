package com.alasala.sis.studentInformationSystem.controller;

import com.alasala.sis.studentInformationSystem.common.ApiResponse;
import com.alasala.sis.studentInformationSystem.common.ResponseBuilder;
import com.alasala.sis.studentInformationSystem.dto.AddStudentDto;
import com.alasala.sis.studentInformationSystem.dto.GetStudentDto;
import com.alasala.sis.studentInformationSystem.service.StudentService;
import com.alasala.sis.studentInformationSystem.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/docker")
    public String dockerCheck(){
        return "Docker File is Uploaded";
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetStudentDto>>> getAllStudent(){
       List<GetStudentDto> list = studentService.getStudentsList();
       return ResponseBuilder.success("List of All Students", list, HttpStatus.OK);
    }

    @GetMapping("/getstudentprofile")
    public GetStudentDto getStudentById(@RequestParam String studentId) {
        return studentService.getStudentByID(studentId);
    }

    @PostMapping("/addstudent")
    public ResponseEntity<ApiResponse<GetStudentDto>> addStudent(@RequestBody @Valid AddStudentDto addStudentDto){
        GetStudentDto studentDto = studentService.addStudent(addStudentDto);
        return ResponseBuilder.success("Student Successfully Admitted", studentDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletestudent")
    public ResponseEntity<ApiResponse<Object>> deleteStudent(@RequestParam String studentId){
       boolean status = studentService.deleteStudent(studentId);
       return ResponseBuilder.success("Successfully Removed from records",null,HttpStatus.OK);
    }

    @PutMapping("/updatestudent")
    public ResponseEntity<ApiResponse<GetStudentDto>> updateStudent(@RequestParam String studentId, @RequestBody AddStudentDto addStudentDto){
        GetStudentDto studentDto= studentService.updateStudent(studentId, addStudentDto);
        return ResponseBuilder.success("Student Record is update Successfully", studentDto,HttpStatus.OK );
    }


    @PatchMapping("/updatestudent")
    public ResponseEntity<ApiResponse<GetStudentDto>> patchStudent(
            @RequestParam String studentId,
            @RequestBody AddStudentDto addStudentDto) {

        GetStudentDto studentDto = studentService.patchStudent(studentId, addStudentDto);
        return ResponseBuilder.success("Student Record is updated Successfully", studentDto, HttpStatus.OK);
    }
}
