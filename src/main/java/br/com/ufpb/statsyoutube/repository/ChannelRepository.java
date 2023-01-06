package br.com.ufpb.statsyoutube.repository;

import java.io.FileReader;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufpb.statsyoutube.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{
    // JSONParser jsonParser = new JSONParser();

    // FileReader reader = new FileReader("histórico-de-visualização.json");
}
