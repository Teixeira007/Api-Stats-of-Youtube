package br.com.ufpb.statsyoutube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

//@Entity
@Setter @Getter
public class ChannelNameTime {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    private String name;
    private LocalDateTime time;

    public ChannelNameTime() {
    }

    public ChannelNameTime(String name, LocalDateTime time){
        this.name = name;
        this.time = time;
    }

    //    CompareTo - usado para ordenar os canais pelo atributo name

    public int compareTo(ChannelNameTime annotherChannel) {
        if((annotherChannel.name.compareTo(this.name)) > 0){
            return -1;
        }else if((annotherChannel.name.compareTo(this.name)) < 0){
            return 1;
        }else{
            return 0;
        }
    }
}
