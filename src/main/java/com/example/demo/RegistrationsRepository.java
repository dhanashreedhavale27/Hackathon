package com.example.demo;

//public package com.example.demo;
//import com.example.demo.Registrations; // Import the model if it's in a subfolder
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationsRepository extends JpaRepository<Registrations, Long> {
} 






