package com.sio.livecricket.controller;


import com.sio.livecricket.entity.Blog;
import com.sio.livecricket.model.BlogDTO;
import com.sio.livecricket.service.BlogService;
import com.sio.livecricket.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public String createBlog(HttpServletRequest request, @Valid BlogDTO blog, BindingResult bindingResult,Model model, RedirectAttributes redirAttrs) {

        if (bindingResult.hasErrors()) return "blog/blog";

        blogService.create(blog);
        model.addAttribute("blog", blog);
        Utils.setGreenMessage(request, "Success");


        return "redirect:/blog";
    }
}
