package com.sio.livecricket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/blog")
public class BlogController {


    @GetMapping
    public String blogList() {
        return "blog/blogList";
    }

    @GetMapping(value = {"/admin/incoTerms/create", "/admin/incoTerms/update", "/admin/incoTerms/view"})
    public String blogView(HttpServletRequest request,
                           @RequestParam(value = "id", required = false) Integer blogId,
                           @RequestParam(value = "viewOnly", required = false) boolean viewOnly,
                           Model model) {


        return "blog/blog";
    }
}
