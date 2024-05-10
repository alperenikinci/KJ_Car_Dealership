package com.alperen.controller;

import com.alperen.dto.request.ImageCreateRequestDto;
import com.alperen.entity.Image;
import com.alperen.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.alperen.constant.RestApiUrls.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(IMAGE)
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = CREATE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<Image>> createImage(@RequestBody @ModelAttribute @Valid ImageCreateRequestDto dto){
    return ResponseEntity.ok(imageService.createImage(dto));
    }

//    @PostMapping(value = "/create-data-impl-images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<List<CarResponseDto>> createDataImplImages(@RequestBody @ModelAttribute @Valid ImageCreateRequestDto dto){
//        return ResponseEntity.ok(imageService.addDataImplImages(dto));
//    }

}
