package senac.feednac.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/version")
public class VersionController {

    @Value("${project-version}")
    private String VERSION;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> version() {
        return ResponseEntity.ok("Versão: " + VERSION);
    }
}
