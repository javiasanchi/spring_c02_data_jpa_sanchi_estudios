package com.example.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {
}