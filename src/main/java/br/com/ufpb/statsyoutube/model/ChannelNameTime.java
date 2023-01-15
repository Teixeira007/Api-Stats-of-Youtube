package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Setter @Getter
public class ChannelNameTime {
    private String name;
    private LocalDateTime time;

    public ChannelNameTime(String name, LocalDateTime time){
        this.name = name;
        this.time = time;
    }
}
