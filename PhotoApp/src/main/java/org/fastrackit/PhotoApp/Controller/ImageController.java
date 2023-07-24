package org.fastrackit.PhotoApp.Controller;

import org.fastrackit.PhotoApp.Model.Image;
import org.fastrackit.PhotoApp.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping("/post")
    public Image uploadImage(@RequestParam("file")MultipartFile file) throws IOException{
        Image image=imageService.uploadImage ( file );
        image.setFileName ( image.getFileName () );
        return image;
    }
    @GetMapping("/get/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) throws IOException {
        Image image = imageService.getImageByFileName(fileName);
        byte[] imageBytes = imageService.getImageBytes( ( image.getFileName() ) );

        return ResponseEntity.ok()
                .header( HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getName() + "\"")
                .body(imageBytes);
    }

}

