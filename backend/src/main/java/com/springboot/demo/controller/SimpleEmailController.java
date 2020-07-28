package com.springboot.demo.controller;

import java.io.IOException;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.springboot.demo.entity.Checkout;
import com.springboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/email")
public class SimpleEmailController {
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@PostMapping("/sendEmail")
	String sendEmailWithAttachment(@RequestBody Checkout c) throws MessagingException, IOException {
		
		
        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);     // true = text/html
        helper.setTo(c.getEmail());
        helper.setSubject("Happy Shopping!!");
       String username=c.getFirstname()+" "+c.getLastname();
     //   ClassPathResource path=new ClassPathResource("thank8.jpg");
        helper.addAttachment("thank8.jpg", new ClassPathResource("thank8.jpg"));
        helper.setText("<h3>Hi "+username+"!!<br>Your order has been placed..<br><br>Your Order Details:<br>    </h3>"+"<br> Your address:<br>"+c.getStreet()+",<br>"+c.getCity()+",<br>"+c.getState()+",<br>"+c.getCountry()+",<br>"+c.getZipcode()+"<br><br>,Thank you for shopping with us!!", true);

        javaMailSender.send(msg);
        System.out.println("Email Sent");
        return "Email sent succesfully!!";
    }
	
}
