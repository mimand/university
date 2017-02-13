/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roy
 */
public class FileUpload {

    private static final String[] ALLOWED_FILE_TYPES = {"image/jpeg","image/png", "image/jpeg", "image/gif"};
    private static final long MAX_FILE_SIZE = 1048576L; // 1 MB
    private byte[] image;
    
    public String process(MultipartFile file) {
        if (!file.isEmpty()) {
            String contentType = file.getContentType().toLowerCase();
            if (isValidContentType(contentType)) {
                if (belowMaxFileSize(file.getSize())) {
                    try {
                        byte [] byteArr=file.getBytes();
                        setImage(byteArr);
                        return "You have successfully uploaded" + file.getOriginalFilename() + "!";
                    } catch (IOException | IllegalStateException iOException) {
                        return "There was an error uploading " + file.getOriginalFilename() + "=>" + iOException.getMessage();
                    }
                } else {
                    return "Error. " + file.getOriginalFilename() + " file size (" + file.getSize() + ") exceeds " + MAX_FILE_SIZE + " limit.";
                }
            } else {
                return "Error. " + contentType + " is not a valid content type.";
            }
        } else {
            return "Error. No file choosen.";
        }
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    private Boolean isValidContentType(String contentType) {
        if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType)) {
            return false;
        }
        return true;
    }

    private Boolean belowMaxFileSize(Long fileSize) {
        if (fileSize > MAX_FILE_SIZE) {
            return false;
        }
        return true;
    }

}
