package org.example.repository;

import org.example.entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament,Long> {

Departament findByName(String name);
}
