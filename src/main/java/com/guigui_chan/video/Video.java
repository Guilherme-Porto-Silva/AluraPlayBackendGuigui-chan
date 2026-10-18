package com.guigui_chan.video;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Table(name = "videos")

public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    private String title;

    private Integer viewAmount;

    private String url;

    private String image;

    public Video (VideoCreationDTO data) {

        title = data.title();

        viewAmount = 0;

        url = data.url();

        image = data.image();
    }
}