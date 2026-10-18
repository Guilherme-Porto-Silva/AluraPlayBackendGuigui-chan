package com.guigui_chan.video;

import jakarta.validation.constraints.NotBlank;

public record VideoCreationDTO (@NotBlank String title, @NotBlank String url, @NotBlank String image) { }