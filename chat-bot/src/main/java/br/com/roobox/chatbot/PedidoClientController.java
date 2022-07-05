package br.com.roobox.chatbot;

import br.com.roobox.chatbot.Whatsapp.Entity.Whatsapp;
import br.com.roobox.chatbot.Whatsapp.Repository.WhatsappRepository;
import br.com.roobox.chatbot.Yampi.Entity.YampiEntity;
import br.com.roobox.chatbot.Yampi.Repository.YampiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chatbot")
public class PedidoClientController {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

    @Autowired
    YampiRepository yampiRepository;

    @Autowired
    WhatsappRepository whatsappRepository;

    @GetMapping("/message")
    public Whatsapp testService() {
        YampiEntity yampi = new YampiEntity();
        yampi = Optional.ofNullable(yampiRepository.findById(1)).orElse(yampi);
        Whatsapp whatsapp = new Whatsapp();
        whatsapp.setCredit("100");
        whatsapp.setDescription("");
        whatsapp.setIntegration("4b3d1194-dc40-4f1c-a6d0-2ce0c4fd75d1");
        whatsapp.setName("Integração Demo Marcus");
        whatsapp.setNumber("5514997426610");
        whatsapp.setQrCode("");
        whatsapp.setYampi(yampi);
       return whatsappRepository.save(whatsapp);

//        YampiEntity yampi = new YampiEntity();
//        yampi.setAlias("abada-pra-tu");
//        yampi.setEmail("");
//        yampi.setNumber("");
//        yampi.setPlan("");
//        yampi.setSecretKey("sk_3WQH0pDFCipfLL8gyXyLyppDNKy6c6mYrkjGC");
//        yampi.setToken("c85193288641a83cabab92cc29eb814a9466c242");
//        yampi.setShopName("");
//        yampiRepository.save(yampi);
//        return yampiRepository.save(yampi);
    }
}