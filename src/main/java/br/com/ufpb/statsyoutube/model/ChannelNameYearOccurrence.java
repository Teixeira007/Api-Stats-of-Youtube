package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ChannelNameYearOccurrence {
    private String name;
    private String year;
    private int occurrence;

    public ChannelNameYearOccurrence(String name, String year, int occurrence) {
        this.name = name;
        this.year = year;
        this.occurrence = occurrence;
    }

    public int compareTo(ChannelNameYearOccurrence annotherChannel) {
        if(annotherChannel.occurrence < this.occurrence){
            return -1;
        }else if(annotherChannel.occurrence > this.occurrence){
            return 1;
        }else{
            return 0;
        }
    }
}
