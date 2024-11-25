package com.example.Libreria.Repository;

import com.example.Libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ariana
 */
public interface LibroRepository extends JpaRepository<Libro,Long> {
    
}



