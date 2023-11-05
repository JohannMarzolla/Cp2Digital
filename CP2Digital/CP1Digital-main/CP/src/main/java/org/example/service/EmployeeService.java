package org.example.service;


import org.example.entity.Departament;
import org.example.entity.Employee;
import org.example.repository.DepartamentRepository;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> buscarTodosFuncionarios(){
        return employeeRepository.findAll();

    }
    public Employee buscarFuncionarioID(Long id){
        return employeeRepository.findById(id).get();
    }

    public Employee salvarFuncionario(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deletarFuncionario(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> buscarFuncionariosSalario(Double salary) {
        return (List<Employee>) employeeRepository.findEmployessBySalary(salary);
    }


}