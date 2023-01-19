package br.com.ufpb.statsyoutube.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ChannelNameYearOccurrence {
    private String name;
    private String year;
    private int occcurrence;

    public ChannelNameYearOccurrence(String name, String year, int occcurrence) {
        this.name = name;
        this.year = year;
        this.occcurrence = occcurrence;
    }
}
