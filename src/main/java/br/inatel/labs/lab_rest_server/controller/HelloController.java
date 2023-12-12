package br.inatel.labs.lab_rest_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello") //pega todas as uris com /hello
public class HelloController {

    @GetMapping
    public MyMessage processarGetHello() {
        final MyMessage msg = new MyMessage();
        msg.setInfo("Olá, mundo REST");
        return msg;
    }

}
