package com.hospital.controller;

import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.User;
import com.hospital.exception.BadRequestException;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AuthController(UserRepository userRepository, 
                         PatientRepository patientRepository,
                         DoctorRepository doctorRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User loggedInUser = userRepository
                .findByUsernameAndPasswordAndRole(
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid Credentials"));
        
        // For PATIENT role, ensure Patient record exists
        if ("PATIENT".equals(loggedInUser.getRole())) {
            // If referenceId is null or patient doesn't exist, create one
            if (loggedInUser.getReferenceId() == null || 
                !patientRepository.existsById(loggedInUser.getReferenceId())) {
                
                Patient patient = new Patient();
                patient.setName(loggedInUser.getUsername());
                patient.setAge(0);
                patient.setGender("");
                patient.setPhone("");
                patient.setDisease("");
                
                Patient savedPatient = patientRepository.save(patient);
                loggedInUser.setReferenceId(savedPatient.getPatientId());
                loggedInUser = userRepository.save(loggedInUser);
            }
        }
        
        // For DOCTOR role, ensure referenceId is set to doctorId
        if ("DOCTOR".equals(loggedInUser.getRole())) {
            final String username = loggedInUser.getUsername();
            Long currentReferenceId = loggedInUser.getReferenceId();
            
            if (currentReferenceId == null) {
                // Try to find doctor by name matching username
                Doctor doctor = doctorRepository.findAll().stream()
                    .filter(d -> d.getName().equalsIgnoreCase(username))
                    .findFirst()
                    .orElse(null);
                
                if (doctor != null) {
                    loggedInUser.setReferenceId(doctor.getDoctorId());
                } else {
                    // If no doctor found, create one
                    Doctor newDoctor = new Doctor();
                    newDoctor.setName(username);
                    newDoctor.setSpecialization("General");
                    newDoctor.setAvailable(true);
                    
                    Doctor savedDoctor = doctorRepository.save(newDoctor);
                    loggedInUser.setReferenceId(savedDoctor.getDoctorId());
                }
                loggedInUser = userRepository.save(loggedInUser);
            } else {
                // Verify the doctor exists
                if (!doctorRepository.existsById(currentReferenceId)) {
                    // Doctor doesn't exist, create one
                    Doctor newDoctor = new Doctor();
                    newDoctor.setName(username);
                    newDoctor.setSpecialization("General");
                    newDoctor.setAvailable(true);
                    
                    Doctor savedDoctor = doctorRepository.save(newDoctor);
                    loggedInUser.setReferenceId(savedDoctor.getDoctorId());
                    loggedInUser = userRepository.save(loggedInUser);
                }
            }
        }
        
        return loggedInUser;
    }

    // PATIENT REGISTRATION ONLY
    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username already exists");
        }
        
        // Create User
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole("PATIENT");
        
        // Create Patient record with provided information
        Patient patient = new Patient();
        patient.setName(request.getUsername()); // Use username as default name, can be updated later
        patient.setAge(request.getAge() != null ? request.getAge() : 0);
        patient.setGender(request.getGender() != null ? request.getGender() : "");
        patient.setPhone(request.getPhone() != null ? request.getPhone() : "");
        patient.setDisease(""); // Can be updated later
        
        // Save patient - ID will be auto-generated by @GeneratedValue
        Patient savedPatient = patientRepository.save(patient);
        
        // Link user to patient via referenceId
        user.setReferenceId(savedPatient.getPatientId());
        
        return userRepository.save(user);
    }
    
    // Inner class for registration request
    public static class RegistrationRequest {
        private String username;
        private String password;
        private Integer age;
        private String gender;
        private String phone;
        
        // Getters and Setters
        public String getUsername() {
            return username;
        }
        
        public void setUsername(String username) {
            this.username = username;
        }
        
        public String getPassword() {
            return password;
        }
        
        public void setPassword(String password) {
            this.password = password;
        }
        
        public Integer getAge() {
            return age;
        }
        
        public void setAge(Integer age) {
            this.age = age;
        }
        
        public String getGender() {
            return gender;
        }
        
        public void setGender(String gender) {
            this.gender = gender;
        }
        
        public String getPhone() {
            return phone;
        }
        
        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
