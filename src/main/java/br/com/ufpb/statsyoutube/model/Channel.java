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
public class Channel implements  Comparable<Channel>{

    @EqualsAndHashCode.Include
    @Id
    private Long id;

    private String name;

    private String url;

    private int occurrence;

    public Channel(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Channel() {

    }

    public Channel(String name, int occurrence){
        this.name = name;
        this.occurrence = occurrence;
    }

    public ChannelNameOccurrence getChannelNameOccurrence(){
        return new ChannelNameOccurrence(name, occurrence);
    }

    @Override
    public String toString() {
        return "Canal [name=" + name + ", url=" + url + "]";
    }

//    CompareTo - usado para ordenar os canais pelo atributo name
    @Override
    public int compareTo(Channel annotherChannel) {
        if((annotherChannel.name.compareTo(this.name)) > 0){
            return -1;
        }else if((annotherChannel.name.compareTo(this.name)) < 0){
            return 1;
        }else{
            return 0;
        }
    }

}
