package com.example.adventurexp_backend.dto;

import com.example.adventurexp_backend.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeConverterTest {

    @Autowired
    EmployeeConverter employeeConverter;

    //Arrange - testdata
    EmployeeDTO employeeDTOTest = new EmployeeDTO(
            10,
            "Mr. T",
            "Mr.T@email.com"
    );

    Employee employeeTest = new Employee(
            10,
            "Mr. T",
            "Mr.T@email.com",
            "1234"
    );


    @Test
    void toEntityTest() {
        //Act
        Employee resultEmployee = employeeConverter.toEntity(employeeDTOTest);

        //Assert
        assertEquals(employeeDTOTest.id(), resultEmployee.getId());
    }

    @Test
    void toDTO() {
        //Act
        EmployeeDTO resultStudentDTO = employeeConverter.toDTO(employeeTest);
        //assert
        assertEquals(employeeTest.getId(), resultStudentDTO.id());
    }
}