package com.guigui_chan.video;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service public class VideoService {

    private VideoRepository DB;

    public VideoService (VideoRepository dataBank) { DB = dataBank; }

    public boolean cadastrateVideo (VideoCreationDTO data) {

        try {
            Video cadastrated = new Video(data);

            DB.saveAndFlush(cadastrated);

            System.out.println("Foi cadastrado um vídeo da seguinte maneira:\n");

            System.out.println(data);

            return true;
        }

        catch (Exception e) {

            System.out.println("Houve uma falha na hora de cadastrar um vídeo. Ele chegou da seguinte maneira:\n");

            System.out.println(data);

            System.out.println("\nO problema ocorrido foi o seguinte:");

            System.out.println(e.getMessage());

            return false;
        }
    }

    public List<Video> query (String researchTerms) {

        List<Video> queried = new ArrayList<>();

        List<String> terms = List.of(researchTerms.split("\\+"));

        for (String term: terms) {

            Optional<List<Video>> titleResearchResult = DB.findByTermInTitle(term);

            if (titleResearchResult.isPresent())

                queried.addAll(titleResearchResult.get());

//          else {

//              Optional<Video> descriptionResearchResult = DB.findByTermInDescription(term);

//              if (descriptionResearchResult.isPresent()) queried.addAll(descriptionResearchResult.get());
//          }
        }

        return queried;
    }

    public List<Video> listVideos () {

        return DB.findAll();
    }
}