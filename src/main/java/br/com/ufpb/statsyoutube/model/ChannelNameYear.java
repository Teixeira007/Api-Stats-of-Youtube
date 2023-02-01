package br.com.ufpb.statsyoutube.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
//@Entity
public class ChannelNameYear {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String name;
    private String timeYear;

    public ChannelNameYear() {
    }

    public ChannelNameYear(String name, String timeYear) {
        this.name = name;
        this.timeYear = timeYear;
    }


    public int compareTo(ChannelNameYear annotherChannel) {
        if((annotherChannel.name.compareTo(this.name)) > 0){
            return -1;
        }else if((annotherChannel.name.compareTo(this.name)) < 0){
            return 1;
        }else{
            return 0;
        }
    }


}
