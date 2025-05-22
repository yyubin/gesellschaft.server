package org.ekujo.gesellschaft.base.service;

public interface S3Service {
    String generatePresignedUrlforPersonaImages(String fileName, String type, String characterName, Long personaId, String contentType);
    String generatePresignedUrlforActiveSkillImages(String fileName, Long skillType, String characterName, Long personaId, String contentType);
}
