package com.cc.sdjpaintro.model;

import com.cc.sdjpaintro.model.sequencegenerators.PublisherPrefixSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Game {
    @Id
    @GenericGenerator(name = "GAME_ID_GENERATOR", strategy = "com.cc.sdjpaintro.model.sequencegenerators.PublisherPrefixSequenceIdGenerator",
    parameters = {
            @Parameter(name = PublisherPrefixSequenceIdGenerator.PREFIX, value = "%s"),
            @Parameter(name = PublisherPrefixSequenceIdGenerator.NUMERIC_SEQUENCE, value = "%05d")
    })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="GAME_ID_GENERATOR")
    private String id;

    private String publisher;
    private Double cost;
}
