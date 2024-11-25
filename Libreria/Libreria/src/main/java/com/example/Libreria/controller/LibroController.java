/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Libreria.Repository.LibroRepository;
import com.example.Libreria.model.Libro;

import java.util.List;
/**
 *
 * @author Ariana
 */
@RestController
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroRepository libroRepository;

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @GetMapping("/listado")
    public List<Libro> listarTodosLosLibros() {
        return libroRepository.findAll();
    }

    @PutMapping("/modifica/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        Libro libro = libroRepository.findById(id).orElse(null);

        if (libro != null) {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setAutor(libroDetalles.getAutor());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setPublicacion(libroDetalles.getPublicacion());
            libro.setPrecio(libroDetalles.getPrecio());
            return libroRepository.save(libro);
        }

        return null;
    }

    @DeleteMapping("/elimina/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}

