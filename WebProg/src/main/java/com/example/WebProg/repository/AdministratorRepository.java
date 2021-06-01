package com.example.WebProg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebProg.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
