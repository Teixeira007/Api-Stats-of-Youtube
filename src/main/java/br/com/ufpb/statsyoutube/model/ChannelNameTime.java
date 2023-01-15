package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ChannelNameTime {
    private String name;
    private String time;

    public ChannelNameTime(String name, String time){
        this.name = name;
        this.time = time;
    }
}
