package com.discord.poo.Discord.Bot.POO;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import java.util.Random;   

@SpringBootApplication
public class DiscordBotPooApplication {

	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(DiscordBotPooApplication.class, args);
	}

	
	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		String token = "ODc5NDY5MzgzODI5ODIzNDk4.YSQLsA.injHgytwN90Gr_jV5-7qW2ioi94";
		DiscordApi api = new DiscordApiBuilder().setToken(token)
		.setAllNonPrivilegedIntents()
		.login()
		.join();
		
		
		api.addMessageCreateListener(event -> {

  		  String [] mensagem = event.getMessageContent().split(" ");

			
			if(mensagem[0].toUpperCase().equals(".OI")) {
				event.getChannel().sendMessage("Au Au!");
			}else {
				if(mensagem[0].toUpperCase().equals(".ROLL")) {
					event.getChannel().sendMessage("Ok");
				}
				
				else {
					if(mensagem[0].toUpperCase().equals(".TESTE")){
							
						if(mensagem.length>1) {
							event.getChannel().sendMessage("O parâmetro inserido foi: " + mensagem[1]);}
						else {
							event.getChannel().sendMessage("Não foi inserido nenhum parâmetro.");
						}
						
					}
					
							
				}
				}
			
			
		}
		);
	
		return api;
	}
}
