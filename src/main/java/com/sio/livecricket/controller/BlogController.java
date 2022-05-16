package com.sio.livecricket.controller;


import com.sio.livecricket.entity.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/blog")
public class BlogController {


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
                             @ModelAttribute("blog") Blog blog, Model model) {

        model.addAttribute("blog", blog);

        return "blog/blog";
    }
}
