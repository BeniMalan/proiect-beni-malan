import React, { useState, ChangeEvent } from 'react';
import axios from 'axios';

const ImageUploader: React.FC = () => {
  const [selectedImage, setSelectedImage] = useState<File | null>(null);
  const [images, setImages] = useState<any[]>([]);

  const handleImageChange = (event: ChangeEvent<HTMLInputElement>) => {
    if (event.target.files && event.target.files[0]) {
      setSelectedImage(event.target.files[0]);
    }
  };

  const handleImageUpload = () => {
    if (selectedImage) {
      const formData = new FormData();
      formData.append('file', selectedImage);

      axios.post('http://localhost:8080/images/post', formData)
        .then((response) => {
          setImages([...images, response.data]);
        })
        .catch((error) => {
          console.error('Error uploading image ', error);
        });
    }
  };

  const handleSortByName = () => {
    const sortedImages = [...images].sort((a, b) => a.name.localeCompare(b.name));
    setImages(sortedImages);
  };
  const imageList = images.map((image) => (
    <div key={image.id}>
      <img
        src={`http://localhost:8080/images/get/${encodeURIComponent(image.fileName)}`}
        alt={image.name}
      />
    </div>
  ));
  
  
  
  
  

  return (
    <div>
      
      <input type="file" onChange={handleImageChange} />

      
      <button onClick={handleImageUpload}>Upload Image</button>

      
      <button onClick={handleSortByName}>Sort by Name</button>

      {imageList}
    </div>
  );
};

export default ImageUploader;
export {};