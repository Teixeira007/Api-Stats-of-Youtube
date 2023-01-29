package br.com.ufpb.statsyoutube.configuration;

import br.com.ufpb.statsyoutube.model.ChannelNameYear;
import br.com.ufpb.statsyoutube.model.ChannelOrigin;
import br.com.ufpb.statsyoutube.repository.ChannelRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;

    public DatabaseLoader(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<ChannelNameYear> channels = new ArrayList<>();
        String pathName = "C:\\Users\\teixe\\Documents\\Api-Stats-of-Youtube\\src\\main\\java\\br\\com\\ufpb\\statsyoutube\\controller\\histórico-de-visualização.json";

        try {
            JsonNode root = mapper.readTree(new File(pathName));
            for (JsonNode node : root) {
                if (node.get("subtitles") != null && node.get("title") != null && node.get("titleUrl") != null
                    && node.get("time") != null
                ) {
                    String header = node.get("header").asText();
                    String title = node.get("title").asText();
                    String titleUrl = node.get("titleUrl").asText();
                    String name = node.get("subtitles").get(0).get("name").asText();
                    String url = node.get("subtitles").get(0).get("url").asText();
                    String time = node.get("time").asText();

                    ChannelOrigin channelOrigin = new ChannelOrigin(header, title, titleUrl, name, url, time);
                    channelRepository.save(channelOrigin);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo JSON: function getChannelAndYear" + e.getMessage());
        }
    }

}
