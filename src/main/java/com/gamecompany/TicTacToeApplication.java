package com.gamecompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class TicTacToeApplication {
    public static void main(String[]args){
        SpringApplication.run(TicTacToeApplication.class, args);
    }
}
