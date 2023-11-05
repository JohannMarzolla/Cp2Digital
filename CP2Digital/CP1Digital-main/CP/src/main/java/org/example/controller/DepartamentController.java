package org.example.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.entity.Departament;
import org.example.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@Tag(name="departamentos",description = "crud de departamentos")
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;

    @PostMapping()
    public ResponseEntity<Departament> criarDepartamento(@Valid @RequestBody Departament departament){
      return ResponseEntity.ok(departamentService.salvarDepartamento(departament)) ;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Departament> buscarDepartamentID(@PathVariable Long id){
        return ResponseEntity.ok(departamentService.buscarDepartamentoID(id));
    }
    @GetMapping()
    public ResponseEntity<List<Departament>> BuscarTodosDepartamentos(){
        return ResponseEntity.ok(departamentService.buscarTodosDepartamentos());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Departament> buscarDepartamentoPorNome(@PathVariable String name){
        return ResponseEntity.ok(departamentService.buscarDepartamentoNome(name));
    }

 @PutMapping()
  public ResponseEntity<Departament> atualizarDepartamento(@PathVariable Long id , @RequestBody Departament departament){
    departament.setId(id);
    return ResponseEntity.ok(departamentService.salvarDepartamento(departament));
    }
  @DeleteMapping()
  public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id ){
        departamentService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();

  }

}



