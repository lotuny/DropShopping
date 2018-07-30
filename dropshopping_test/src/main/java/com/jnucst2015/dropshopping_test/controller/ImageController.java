package com.jnucst2015.dropshopping_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @GetMapping("/images/upload/{imageName}")
    public void getImage(@PathVariable("imageName") String imageName,
                         HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        File image = new File("E:\\images\\"+imageName);
        if (!image.exists()) image = new File("E:\\images\\notfound.jpg");
        InputStream is = new FileInputStream(image);
        BufferedImage bi = ImageIO.read(is);
        ImageIO.write(bi,"JPEG",response.getOutputStream());

    }

}
