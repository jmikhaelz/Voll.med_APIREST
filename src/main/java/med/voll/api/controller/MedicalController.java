package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.model.medical.DataMedical;
import med.voll.api.model.medical.Medical;
import med.voll.api.repository.MedicalResp;

@RestController
@RequestMapping("/medicos")
public class MedicalController {
    @Autowired
    private MedicalResp respository;

    @Transactional
    @PostMapping
    public void set(@RequestBody @Valid DataMedical data) {
        respository.save(new Medical(data));
    }

    @GetMapping
    public String get() {
        return "medicos";
    }
}
