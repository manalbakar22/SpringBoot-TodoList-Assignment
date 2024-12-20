package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Tasak;


public interface TaskRepository extends JpaRepository<Tasak, Long> {

}
