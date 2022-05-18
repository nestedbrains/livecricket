package com.sio.livecricket.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Boolean GREEN_MSG = true;

    public static void setGreenMessage(HttpServletRequest request, String message) {
        HttpSession session = request.getSession();

        session.setAttribute("greenMessage", message);
    }

    public static Object getGreenMessage(HttpServletRequest request) {
        if (request.getSession().getAttribute("greenMessage") != null) {
            Object message = request.getSession().getAttribute("greenMessage");
            request.getSession().removeAttribute("greenMessage");
            return message;
        }
        return "";
    }

    public static String getGreenMessage() {
        return "success";


    }

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException, IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    public static String getUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    }

    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }
}
