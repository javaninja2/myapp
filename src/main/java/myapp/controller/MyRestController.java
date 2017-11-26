package myapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import myapp.model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class MyRestController {

    private static final String TEMPLATE = "Hi There %s!";
    private static  AtomicLong counter  = new AtomicLong();
    
    @RequestMapping ({"/rest" })
    public Message greeting (@RequestParam(value="name", defaultValue="Munster") String name) {
        return new Message(counter.incrementAndGet(), String.format(TEMPLATE, name) );
    }
 }
