package com.example.adventurexp_backend.service;

import com.example.adventurexp_backend.dto.EmployeeConverter;
import com.example.adventurexp_backend.dto.EmployeeDTO;
import com.example.adventurexp_backend.exception.NotFoundException;
import com.example.adventurexp_backend.model.Employee;
import com.example.adventurexp_backend.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
class EmployeeServiceTest {

    //@InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository mockedEmployeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;


    @BeforeEach
    void init(){
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("John Doe");
        e1.setEmail("JohnDoe@email.com");
        e1.setPassword("123");

        Employee e2 = new Employee(
                2,
                "Jane Doe",
                "JaneDoe@email.com",
                "1234"
        );
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        //findall giver liste af employees
        Mockito.when(mockedEmployeeRepository.findAll()).thenReturn(employeeList);
        //findById giver employee på id=1 og empty på id=3
        Mockito.when(mockedEmployeeRepository.findById(1)).thenReturn(Optional.of(e1));
        Mockito.when(mockedEmployeeRepository.findById(2)).thenReturn(Optional.of(e2));
        Mockito.when(mockedEmployeeRepository.findById(3)).thenReturn(Optional.empty());
        //deleteById giver empty hvis id = 3 - doThrow bruges, da deleteById er void
        doThrow(new NotFoundException("Employee not found with id: 3")).when(mockedEmployeeRepository).deleteById(3);

    // Define the behavior using thenAnswer
    // The employee passed in save, can be read from arguments in the InvocationOnMock object
        Mockito.when(mockedEmployeeRepository.save(ArgumentMatchers.any(Employee.class))).thenAnswer(new Answer<Employee>() {
        @Override
        public Employee answer(InvocationOnMock invocation) throws Throwable {
            // Extract the student object passed as an argument to the save method
            Object[] arguments = invocation.getArguments();
            if (arguments.length > 0 && arguments[0] instanceof Employee) {
                Employee employeeToSave = (Employee) arguments[0];
                //er id = 0, så simuler create - er id sat så simuler opdater
                if (employeeToSave.getId()==0) {
                    //create - repository skal returnere studentobject med næste ledige id = 3
                    employeeToSave.setId(69);
                }
                return employeeToSave;
            } else {
                // Handle the case where the argument is not a Student (optional)
                throw new IllegalArgumentException("Invalid argument type");
            }
        }
    });
    //inject mocked repository and other dependencies in studentService
    employeeService = new EmployeeService(employeeConverter, mockedEmployeeRepository);

}

    @Test
    void getAllEmployees() {
        //Act
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        //Assert
        assertEquals("John Doe", employeeDTOList.get(0).name());
        assertEquals("Jane Doe", employeeDTOList.get(1).name());
    }

    @Test
    void getStudentById() {
        //Act
        EmployeeDTO studentDTO = employeeService.getEmployeeById(1);
        //Assert
        assertEquals("John Doe", studentDTO.name());
        assertThrows(NotFoundException.class, () -> employeeService.getEmployeeById(3));
    }

    @Test
    void createEmployee() {
        EmployeeDTO resultEmployeeDTO = employeeService.createEmployee(employeeConverter.toDTO(
                new Employee(
                        0,
                        "Nichlas",
                        "Nichlas@email.com",
                        "123"
                )));
        assertEquals(69, resultEmployeeDTO.id());
    }


    @Test
    void updateEmployee() {
        EmployeeDTO resultEmployeeDTO = employeeService.updateEmployee(1, employeeConverter.toDTO(
                new Employee(
                        1,
                        "John Doe",
                        "JohnDoe@email.com",
                        "1234"
                )
        ));

    }

    @Test
    void deleteEmployee() {
    }
}