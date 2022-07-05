package br.com.roobox.chatbot.Yampi.ChatbotYampi.Controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequestMapping("/chatbot")
public class ChatbotController {

    @GetMapping("/config")
    public String config() {
        return "Drop/Chatbot/config";
    }

    @PostMapping("/configMenu")
    public String receiveMessage(@RequestParam("0") String menuPrincipal){
//TODO termainar
        return "";
    }
}
