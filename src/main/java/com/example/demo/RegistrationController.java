package com.example.demo;

// Core Spring Framework Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Utility Import for Parsing Payload Maps
import java.util.Map;

// CRITICAL: Import your Models and Repositories so the controller knows they exist
import com.example.demo.Event;
import com.example.demo.Registrations;
import com.example.demo.EventRepository;
import com.example.demo.RegistrationsRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationsRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudentToEvent(@RequestBody Map<String, Object> payload) {
        try {
            // Extract and parse the targeted event identifier
            Long eventId = Long.parseLong(payload.get("eventId").toString());
            Event event = eventRepository.findById(eventId)
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            // Instantiate a new Registration object mapping matching payload inputs
            Registrations reg = new Registrations(
                    payload.get("studentName").toString(),
                    payload.get("regNo").toString(),
                    payload.get("deptName").toString(),
                    payload.get("courseName").toString(),
                    payload.get("division").toString(),
                    event
            );

            // Persist securely to MySQL tables via JPA repository interface layers
            Registrations savedReg = registrationRepository.save(reg);
            return ResponseEntity.ok(savedReg);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing registration: " + e.getMessage());
        }
    }
}