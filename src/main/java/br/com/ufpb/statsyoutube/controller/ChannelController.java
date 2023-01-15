package br.com.ufpb.statsyoutube.controller;

import br.com.ufpb.statsyoutube.model.ChannelNameOccurrence;

import java.util.Collections;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//		System.out.println(channels.size());
		Collections.sort(channels);
		return channels;
	}

//	Pega uma lista com os nomes dos canais, ordena e conta quantas vezes cada canal foi visto
	@GetMapping("/frequency")
	public List<ChannelNameOccurrence> getMoreOccurrencesOfAllTime(){

		List<String> channels;
		channels = getListChannels();
//		Collections.sort(channels);

		String current = null;
		List<ChannelNameOccurrence> listChannelsFrequency = new ArrayList<>();
		int cnt = 0;

		for(int i =0; i<channels.size(); i++){
			if(!channels.get(i).equals(current)){
				if(cnt > 0){
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

//	Pegar todos os canais com mais de 100 ocorrências
	@GetMapping("/more100")
	public List<ChannelNameOccurrence> more100Occurrence(){
		List<ChannelNameOccurrence> channels;
		channels = getMoreOccurrencesOfAllTime();
		return channels.stream().filter(x -> x.getOccurrence() > 100).collect(Collectors.toList());
	}

//	Retorna o topX de canais mais assistidos
	@GetMapping("/topX/{X}")
	public List<ChannelNameOccurrence> topXOccurrence(@PathVariable("X") int x){
		List<ChannelNameOccurrence> channels;
		channels = getMoreOccurrencesOfAllTime();
		return channels.stream().limit(x).collect(Collectors.toList());
	}

//	Retorna uma lista com as datas de todos os videos
	public List<String> getAllTheDatesOfTheVideos(){

		ObjectMapper mapper = new ObjectMapper();
		List<String> channels = new ArrayList<>();
		String pathName = "C:\\Users\\teixe\\Documents\\Api-Stats-of-Youtube\\src\\main\\java\\br\\com\\ufpb\\statsyoutube\\controller\\histórico-de-visualização.json";

		try {
			JsonNode root = mapper.readTree(new File(pathName));
			for (JsonNode node : root) {
				if (node.get("subtitles") != null) {
					String time = node.get("time").asText();
					channels.add(time);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo JSON: " + e.getMessage());
		}

		return channels;
	}
	
}
