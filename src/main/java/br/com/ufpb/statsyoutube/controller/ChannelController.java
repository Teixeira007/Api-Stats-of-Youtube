package br.com.ufpb.statsyoutube.controller;

import br.com.ufpb.statsyoutube.model.ChannelNameOccurrence;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.ufpb.statsyoutube.model.Channel;

@RestController
@RequestMapping("/channels")
public class ChannelController {
	
//	Converte um arquivo JSON em uma lista de objetos ordenados
	@GetMapping
	public List<String> getListChannels(){

		ObjectMapper mapper = new ObjectMapper();
		List<String> channels = new ArrayList<>();
		String pathName = "C:\\Users\\teixe\\Documents\\Api-Stats-of-Youtube\\src\\main\\java\\br\\com\\ufpb\\statsyoutube\\controller\\histórico-de-visualização.json";
		Long idCont = 1L;

		try {
			JsonNode root = mapper.readTree(new File(pathName));
			for (JsonNode node : root) {
				if (node.get("subtitles") != null) {
//					Long id = idCont;
					String name = node.get("subtitles").get(0).get("name").asText();
					channels.add(name);
//					String url = node.get("subtitles").get(0).get("url").asText();
//					channels.add(new Channel(id, name, url));
//					idCont++;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo JSON: " + e.getMessage());
		}


//		Collections.sort(channels);
//		for(int i=0; i<channels.size();i++){
//			System.out.println(channels.get(i).getName());
//		}
		System.out.println(channels.size());
		return channels;
	}

	@GetMapping("/frequency")
	public List<ChannelNameOccurrence> getMoreOccurrencesOfAllTime(){

		List<String> channels;
		channels = getListChannels();
//		Collections.sort(channels, Channel::compareTo);
		Collections.sort(channels);

		String current = null;
		List<ChannelNameOccurrence> listChannelsFrequency = new ArrayList<>();
		int cnt = 0;


		for(int i =0; i<channels.size(); i++){
//			System.out.println(channels.get(i).getName());
			if(!channels.get(i).equals(current)){
				if(cnt > 0){
//					listChannelsFrequency.add(new Channel(channels.get(i-1), cnt));
					listChannelsFrequency.add(new ChannelNameOccurrence(channels.get(i-1), cnt));
				}
				current = channels.get(i);
				cnt = 1;
			}else{
				cnt++;
			}
		}

		Collections.sort(listChannelsFrequency, ChannelNameOccurrence::compareTo);
		return listChannelsFrequency;
	}
	
}
