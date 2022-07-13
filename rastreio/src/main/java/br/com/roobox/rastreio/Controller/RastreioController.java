package br.com.roobox.rastreio.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RastreioController {

    @PostMapping
    public String consultaRastreio(){

        return "";
    }
}
