package br.com.ufpb.statsyoutube.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.ufpb.statsyoutube.model.Channel;

@RestController
@RequestMapping("/channels")
public class ChannelController {
	
	// @GetMapping
	// public String hello() {
	// 	return "hello mundo";
	// }

	@GetMapping
	public List<Channel> getChannels() throws IOException{
		Gson gson = new Gson();
		// Lê o arquivo JSON
		try{
			FileReader reader = new FileReader("src/main/java/br/com/ufpb/statsyoutube/controller/histórico-de-visualização.json");

			// Converte o arquivo JSON em uma lista de objetos da classe MyClass
			Type listType = new TypeToken<List<Channel>>(){}.getType();
			List<Channel> myClassList = gson.fromJson(reader, listType);
			return myClassList;
		}catch(IOException e){
			// e.printStackTrace();
			throw new IOException();
		}


		// Gson gson = new Gson();
		// String json = "";

		// try {
		// 	json = new String(Files.readAllBytes(Paths.get("src/main/java/br/com/ufpb/statsyoutube/controller/histórico-de-visualização.json")));
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }

		// Type listType = new TypeToken<ArrayList<Channel>>(){}.getType();
		// List<Channel> channels = gson.fromJson(json, listType);

		// return channels;
	}
	
}
