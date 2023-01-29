package br.com.ufpb.statsyoutube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter @Getter
public class ChannelOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String header;
    private String title;
    private String titleUrl;
    private String name;
    private String url;
    private String time;

    public ChannelOrigin() {
    }

    public ChannelOrigin(String header, String title, String titleUrl, String name, String url, String time) {
        this.header = header;
        this.title = title;
        this.titleUrl = titleUrl;
        this.name = name;
        this.url = url;
        this.time = time;
    }
}
