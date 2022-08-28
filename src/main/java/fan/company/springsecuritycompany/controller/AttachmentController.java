package fan.company.springsecuritycompany.controller;

import fan.company.springsecuritycompany.entity.Attachment;
import fan.company.springsecuritycompany.payload.Result;
import fan.company.springsecuritycompany.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/uploadFileToFileSystem")
    public Result uploadFileToFileSystem(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.uploadFileToFileSystem(request);
    }

    @GetMapping("/downloadFileFromFileSystem/{id}")
    public Result downloadFileFromFileSystem (@PathVariable Long id, HttpServletResponse response){
        return attachmentService.downloadFromFileSystem(id, response);
    }

    @GetMapping("/info")
    public List<Attachment> getAllPhotos(){
        return attachmentService.getAllPhotos();
    }

    @GetMapping("/info/{id}")
    public Attachment getByIdPhoto(@PathVariable Long id){
        return attachmentService.getByIDPhoto(id);
    }












}
