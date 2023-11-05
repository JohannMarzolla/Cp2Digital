package org.example.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.entity.Departament;
import org.example.entity.Employee;
import org.example.service.DepartamentService;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Tag(name="funcionarios",description = "crud de funcionarios")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Employee> cadastrarFuncionario(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.salvarFuncionario(employee)) ;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> buscarFuncionarioID(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.buscarFuncionarioID(id));
    }
    @GetMapping()
    public ResponseEntity<List<Employee>> BuscarTodosFuncionarios(){
        return ResponseEntity.ok(employeeService.buscarTodosFuncionarios());
    }
    @GetMapping("/{salary}")
    public ResponseEntity<List<Employee>> BuscarFuncionariosPorSalario(@PathVariable Double salary){
        return ResponseEntity.ok(employeeService.buscarFuncionariosSalario( salary));
    }


    @PutMapping()
    public ResponseEntity<Employee> atualizarFuncionario(@PathVariable Long id , @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok(employeeService.salvarFuncionario(employee));
    }
    @DeleteMapping()
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id ){
        employeeService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();

    }

}
