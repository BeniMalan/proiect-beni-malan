package org.fastrackit.PhotoApp.Service;

import org.fastrackit.PhotoApp.Model.Image;
import org.fastrackit.PhotoApp.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image uploadImage(MultipartFile file) throws IOException {
        String uploadDirectory = "C:\\Users\\malan\\Desktop\\won11\\PhotoApp\\PhotoApp\\PhotoApp\\upload dir";
        String fileName = file.getOriginalFilename();
        String filePath = uploadDirectory + File.separator + fileName;
        file.transferTo(new File(filePath));

        Image image = new Image();
        image.setName(fileName);
        image.setFileName( ( fileName ) ) ;

        return imageRepository.save(image);
    }
    public Image getImageByFileName(String fileName) {
        return imageRepository.findByFileName(fileName);
    }
    public byte[] getImageBytes(String filePath) throws IOException {
        File imageFile = new File(filePath);
        return Files.readAllBytes(imageFile.toPath());
    }
}
