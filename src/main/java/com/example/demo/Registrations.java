package com.example.demo;

//package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class Registrations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String regNo;
    private String deptName;
    private String courseName;
    private String division;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Constructors
    public Registrations() {}

    public Registrations(String studentName, String regNo, String deptName, String courseName, String division, Event event) {
        this.studentName = studentName;
        this.regNo = regNo;
        this.deptName = deptName;
        this.courseName = courseName;
        this.division = division;
        this.event = event;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
