package ru.kuper.twodbapp.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kuper.twodbapp.domain.Image;
import ru.kuper.twodbapp.repo.ImageRepo;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("/image")
public class ImageController {

    private ImageRepo imageRepo;

    public ImageController(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @GetMapping
    public String getFormToLoadImage(Model model) {
        model.addAttribute("message","Max 5 MB");
        return "image";
    }

    @PostMapping
    public String loadImage(@RequestParam("description") String description,
                            @RequestParam("file") MultipartFile file) throws Exception {

        Byte[] barray = new Byte[file.getBytes().length];
        int i = 0;
        for (byte b: file.getBytes()) barray[i++] = b;

        imageRepo.save(new Image(description,barray));

        return "redirect:/image";
    }

    @GetMapping("/{id}")
    public void renderImage(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");
        Image image = imageRepo.findById(Long.valueOf(id)).get();
        Byte[] im = image.getImage();
        byte[] barray = new byte[im.length];
        int i = 0;
        for (byte b: im) barray[i++] = b;
        InputStream is = new ByteArrayInputStream(barray);
        OutputStream os = response.getOutputStream();
        IOUtils.copy(is,os);

    }


}
