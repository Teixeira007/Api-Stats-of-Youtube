package br.com.ufpb.statsyoutube.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;


@Entity
@Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Channel {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

    public Channel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Channel() {

    }


    @Override
    public String toString() {
        return "Canal [name=" + name + ", url=" + url + "]";
    }

    
}
