package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ChannelNameYear {
    private String name;
    private String year;

    public ChannelNameYear(String name, String year) {
        this.name = name;
        this.year = year;
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
