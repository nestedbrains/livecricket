package com.sio.livecricket.controller;


import com.sio.livecricket.model.BlogDTO;
import com.sio.livecricket.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/blogs", produces = MediaType.APPLICATION_JSON_VALUE)
public class BlogRestController {

    private final BlogService blogService;

    public BlogRestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        return ResponseEntity.ok(blogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable final Long id) {
        return ResponseEntity.ok(blogService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createBlog(@RequestBody @Valid final BlogDTO blogDTO) {
        return new ResponseEntity<>(blogService.create(blogDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBlog(@PathVariable final Long id,
                                           @RequestBody @Valid final BlogDTO blogDTO) {
        blogService.update(id, blogDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable final Long id) {
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
