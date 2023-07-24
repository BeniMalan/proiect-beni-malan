package org.fastrackit.PhotoApp.Repository;

import org.fastrackit.PhotoApp.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByFileName(String fileName);
}
