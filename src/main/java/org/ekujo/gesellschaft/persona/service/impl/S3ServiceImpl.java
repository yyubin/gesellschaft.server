package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.base.config.S3Properties;
import org.ekujo.gesellschaft.persona.service.S3Service;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URL;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {

    private final S3Presigner s3Presigner;
    private final S3Properties s3Properties;

    public String generatePresignedUrlforPersonaImages(String fileName, String type, String characterName, Long personaId) {
        String key = "character/gallery/" + characterName + "/id_" + personaId +
                "/id_" + personaId + "_" + type + "_" + fileName;

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(s3Properties.getBucket())
                .key(key)
                .contentType("image/jpeg")
                .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(objectRequest)
                .build();

        URL presignedUrl = s3Presigner.presignPutObject(presignRequest).url();
        return presignedUrl.toString();
    }


}
