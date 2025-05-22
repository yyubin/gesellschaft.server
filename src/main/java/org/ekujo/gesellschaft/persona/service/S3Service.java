package org.ekujo.gesellschaft.persona.service;

public interface S3Service {
    String generatePresignedUrl(String fileName, String type);
}
