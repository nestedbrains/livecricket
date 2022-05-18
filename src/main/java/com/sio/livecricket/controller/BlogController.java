package com.sio.livecricket.controller;


import com.sio.livecricket.entity.Blog;
import com.sio.livecricket.model.BlogDTO;
import com.sio.livecricket.service.BlogService;
import com.sio.livecricket.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    BlogService blogService;

    @GetMapping
    public String blogList() {
        return "blog/blogList";
    }

    @GetMapping(value = {"/create", "/update", "/view"})
    public String blogView(HttpServletRequest request,
                           @RequestParam(value = "id", required = false) Integer blogId,
                           @RequestParam(value = "viewOnly", required = false) boolean viewOnly,
                           Model model) {

        Blog blog = new Blog();

        model.addAttribute("blog", blog);

        return "blog/blog";
    }

    @PostMapping(value = {"/create", "/update"})
    public String createBlog(HttpServletRequest request,
                             @Valid BlogDTO blog,
                             BindingResult bindingResult,
                             Model model,
                             @RequestParam("image") MultipartFile multipartFile,
                             RedirectAttributes redirAttrs) throws IOException {

        if (bindingResult.hasErrors()) return "blog/blog";


        String fileName =StringUtils.cleanPath(multipartFile.getOriginalFilename());


        blog.setImageUrl(Utils.getUrl() + "/user-photos/" + fileName);
        String uploadDir = "user-photos/";
        Utils.saveFile(uploadDir, fileName, multipartFile);
        blogService.create(blog);

        model.addAttribute("blog", blog);
        redirAttrs.addFlashAttribute("success", "Blog has save successfully ");

        return "redirect:/blog";
    }
}
