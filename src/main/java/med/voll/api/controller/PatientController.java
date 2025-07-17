package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.model.patient.DataPatient;
import med.voll.api.model.patient.Patient;
import med.voll.api.repository.PatientResp;

@RestController
@RequestMapping("/pacientes")
public class PatientController {
    @Autowired
    private PatientResp respository;


    @PostMapping
    public void set(@RequestBody DataPatient data) {
        respository.save(new Patient(data));
    }

    @GetMapping
    public String get() {
        return "pacientes";
    }
}
