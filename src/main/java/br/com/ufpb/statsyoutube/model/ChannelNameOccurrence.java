package br.com.ufpb.statsyoutube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ChannelNameOccurrence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int occurrence;

    public ChannelNameOccurrence() {
    }

    public ChannelNameOccurrence(String name, int occurrence){
        this.name = name;
        this.occurrence = occurrence;
    }

//  CompareTo - usado para ordenar os canais pelo atributo occurrence
    public int compareTo(ChannelNameOccurrence annotherChannel) {
        if(annotherChannel.occurrence < this.occurrence){
            return -1;
        }else if(annotherChannel.occurrence > this.occurrence){
            return 1;
        }else{
            return 0;
        }
    }
}
