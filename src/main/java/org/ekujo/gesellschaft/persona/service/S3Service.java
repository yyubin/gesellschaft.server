package org.ekujo.gesellschaft.persona.service;

public interface S3Service {
    String generatePresignedUrlforPersonaImages(String fileName, String type, String characterName, Long personaId);
}
