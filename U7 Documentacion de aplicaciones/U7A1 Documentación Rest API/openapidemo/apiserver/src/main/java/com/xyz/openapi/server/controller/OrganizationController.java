package com.xyz.openapi.server.controller;

import com.xyz.openapi.server.model.Department;
import com.xyz.openapi.server.model.Employee;
import com.xyz.openapi.server.model.EmployeeList;
import com.xyz.openapi.server.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Tag(name = "Organization Controls", description = "API Endpoints to operate on Employee and Departments")
public class OrganizationController {
    private List<Employee> employees = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();

    @GetMapping(value = "/employees") // Metodo para obtener todos los empleados
    @Operation(summary = "If departmentId is not passed, get all employees. Otherwise get employees from specific department.") // Descripcion del metodo
    @ApiResponses({ // Respuestas posibles
            @ApiResponse(responseCode = "200", content = { // Respuesta exitosa
                    @Content(schema = @Schema(implementation = EmployeeList.class)) //Se devuelve un objeto EmployeeList
            }),
            @ApiResponse(responseCode = "500", content = { // Respuesta de error
                    @Content(schema = @Schema(implementation = ErrorResponse.class)) //Se devuelve un objeto ErrorResponse
            })
    })
    public EmployeeList getAllEmployees(@RequestParam(required = false) String deptId) {
        List<Employee> employees = this.employees.stream()
                .filter(emp -> deptId == null ||
                        (deptId != null && emp.getDepartment() != null && emp.getDepartment().getId().equals(deptId)))
                .collect(Collectors.toList());
        return EmployeeList.of(employees);
    }

    @GetMapping(value = "/employees/{id}") // Metodo para obtener un empleado por id
    public Employee getEmployee(@PathVariable String id) {
        Optional<Employee> optional = employees.stream()
                .filter(emp -> emp.getId().equals(id))
                .findAny();
        if(optional.isEmpty()) {
            throw new IllegalArgumentException("Employee does not exist for id: "+id);
        }
        return optional.get();
    }

    @PostMapping(value = "/employees") // Metodo para crear un empleado
    public String createEmployee(@RequestBody Employee emp){
        emp.setId(UUID.randomUUID().toString());
        employees.add(emp);
        return emp.getId();
    }

    @PutMapping(value = "/employees") // Metodo para actualizar un empleado
    public String updateEmployee(Employee updatedEmp){
        employees.stream()
                .filter(e -> updatedEmp.getId().equals(e.getId()))
                .findFirst()
                .map(emp -> {
                    BeanUtils.copyProperties(updatedEmp, emp);
                    return emp;
                })
                .orElseThrow();
        return updatedEmp.getId();
    }

    @GetMapping(value = "/departments") // Metodo para obtener todos los departamentos
    public List<Department> getAllDepartments() {
        return departments;
    }

    @GetMapping(value = "/departments/{id}") // Metodo para obtener un departamento por id
    public Department getDepartment(@PathVariable String id) {
        Optional<Department> optional = departments.stream()
                .filter(emp -> emp.getId().equals(id))
                .findAny();
        if(optional.isEmpty()) {
            throw new IllegalArgumentException("Department does not exist for id: "+id);
        }
        return optional.get();
    }

    @PostMapping(value = "/departments") // Metodo para crear un departamento
    public String createDepartment(Department department){
        department.setId(UUID.randomUUID().toString());
        departments.add(department);
        return department.getId();
    }

}