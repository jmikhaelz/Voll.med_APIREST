package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.model.patient.DataPatient;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @PostMapping
    public void set(@RequestBody DataPatient data) {
        System.out.println(data);
    }

    @GetMapping
    public String get() {
        return "pacientes";
    }
}
