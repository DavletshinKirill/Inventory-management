package com.inventory_management.service.impl;

import com.inventory_management.domain.ProductImage;
import com.inventory_management.domain.exception.ImageUploadException;
import com.inventory_management.service.interfaces.ProductImageService;
import com.inventory_management.service.props.MinioProperties;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final MinioClient minioClient;
    private final MinioProperties minioProperty;
    @Override
    public String upload(ProductImage image) {
        try {
            createBucket();
        }
        catch (Exception e) {
            throw new ImageUploadException("Image upload failed" + e.getMessage());
        }
        MultipartFile file = image.getFile();
        if(file.isEmpty() || file.getOriginalFilename() == null) {
            throw new ImageUploadException("Image upload failed. File is Empty or have not name");
        }
        String fileName = generateFileName(file);
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (Exception e) {
            throw new ImageUploadException("Input Stream failed" + e.getMessage());
        }
        saveImage(inputStream, fileName);
        return fileName;
    }

    @SneakyThrows
    @Override
    public InputStream download(String moviePath) {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(minioProperty.getBucket())
                        .object(moviePath)
                        .build());
    }

    @SneakyThrows
    @Override
    public void deleteImage(String imagePath) {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(minioProperty.getBucket())
                        .object(imagePath)
                        .build()
        );
    }


    @SneakyThrows
    private void createBucket() {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(minioProperty.getBucket())
                .build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .build());
        }
    }

    private String generateFileName(MultipartFile multipartFile) {
        String extension = getExtention(multipartFile);
        return UUID.randomUUID() + "." + extension;
    }

    private String getExtention(MultipartFile file) {
        return file.getOriginalFilename()
                .substring(file.getOriginalFilename()
                        .lastIndexOf(".") + 1);
    }

    @SneakyThrows
    private void saveImage(
            final InputStream inputStream,
            final String fileName
    ) {
        minioClient.putObject(PutObjectArgs.builder()
                .stream(inputStream, inputStream.available(), -1)
                .bucket(minioProperty.getBucket())
                .object(fileName)
                .build());
    }
}
