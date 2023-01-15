package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChannelNameOccurrence {
    private String name;
    private int occurrence;

    public ChannelNameOccurrence(String name, int occurrence){
        this.name = name;
        this.occurrence = occurrence;
    }

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
