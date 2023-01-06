package br.com.ufpb.statsyoutube.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Channel {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    
    @OneToOne(cascade = CascadeType.ALL)
    private Subtitles subtitles;
    // @Column(nullable = false)
    // private ArrayList<String> subtitles = new ArrayList<>();
    
    
    
}
