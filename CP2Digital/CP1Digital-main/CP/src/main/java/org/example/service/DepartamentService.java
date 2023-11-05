package org.example.service;

import org.example.entity.Departament;
import org.example.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;
    public List<Departament> buscarTodosDepartamentos(){
        return departamentRepository.findAll();

    }
    public Departament buscarDepartamentoID(Long id){
        return departamentRepository.findById(id).get();
    }

    public Departament salvarDepartamento(Departament departament){
        return departamentRepository.save(departament);
    }
    public void deletarDepartamento(Long id){
        departamentRepository.deleteById(id);
    }
    public Departament buscarDepartamentoNome(String name){
        return departamentRepository.findByName(name);
    }


}
