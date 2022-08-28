package fan.company.springsecuritycompany.services;

import fan.company.springsecuritycompany.entity.Attachment;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.repository.AttachmentContentRepository;
import fan.company.springsecuritycompany.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;


    private static final String uploadFile = "YuklanganFayllar";

    public Result uploadFileToFileSystem(MultipartHttpServletRequest request) throws IOException {

        try {

            Iterator<String> fileNames = request.getFileNames();
            List<String> idlar = new ArrayList<>();

            while (fileNames.hasNext()) {

                MultipartFile file = request.getFile(fileNames.next());
                if (!file.isEmpty()) {
                    String originalFilename = file.getOriginalFilename();
                    Attachment attachment = new Attachment();
                    attachment.setOriginalName(originalFilename);
                    attachment.setSize(file.getSize());
                    attachment.setContentType(file.getContentType());
                    String[] split = originalFilename.split("\\.");
                    String name = UUID.randomUUID().toString() + "." + split[split.length - 1];
                    attachment.setName(name);
                    Attachment savedAttachment = attachmentRepository.save(attachment);
                    File path = new File(uploadFile);
                    path.mkdir();
                    path = new File(path.getPath() + "/" + name);
                    Files.copy(file.getInputStream(), Path.of(path.getPath()));
                    idlar.add(savedAttachment.getId().toString());
                }

            }
            return new Result("Fayl saqlanfi" + idlar, true);

        } catch (Exception e) {
            return new Result("Xatolik yuz berdi", false);
        }
    }

    public Result downloadFromFileSystem(Long id, HttpServletResponse response) {

        try {
            Optional<Attachment> byIdAttachment = attachmentRepository.findById(id);
            if (!byIdAttachment.isPresent())
                return new Result("Bunday idlik fayl yo'q", false);

            Attachment attachment = byIdAttachment.get();
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + attachment.getOriginalName() + "\"");
            response.setContentType(attachment.getContentType());

            FileInputStream fileInputStream = new FileInputStream(uploadFile + "/" + attachment.getName());
            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
            return new Result("Fayl yuklandi", true);

        } catch (Exception e) {
            return new Result("Xatolik yuz berdi", false);
        }
    }


    public List<Attachment> getAllPhotos() {
        return attachmentRepository.findAll();
    }

    public Attachment getByIDPhoto(Long id) {
        boolean existsById = attachmentRepository.existsById(id);
        if (!existsById)
            return new Attachment();
        return attachmentRepository.findById(id).get();
    }

}
