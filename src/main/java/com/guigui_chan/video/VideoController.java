package com.guigui_chan.video;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/videos") public class VideoController {

    @Autowired VideoService service;

    @PostMapping public ResponseEntity cadastrateVideo (@RequestBody @Valid VideoCreationDTO data) {

        if (service.cadastrateVideo(data)) return ResponseEntity.ok("Video cadastrado com sucesso. :)");

        return ResponseEntity.badRequest().body("Confira se as informações foram enviadas corretamente.");
    }

    @GetMapping public ResponseEntity query (@RequestParam(required = false) String q) {

        if (q == null || q.isEmpty()) return ResponseEntity.ok(service.listVideos());

        else return ResponseEntity.ok(service.query(q));
    }
}