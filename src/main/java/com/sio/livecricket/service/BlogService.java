package com.sio.livecricket.service;



import com.sio.livecricket.entity.Blog;
import com.sio.livecricket.model.BlogDTO;
import com.sio.livecricket.repository.BlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(final BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDTO> findAll() {
        return blogRepository.findAll()
                .stream()
                .map(blog -> mapToDTO(blog, new BlogDTO()))
                .collect(Collectors.toList());
    }

    public BlogDTO get(final Long id) {
        return blogRepository.findById(id)
                .map(blog -> mapToDTO(blog, new BlogDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final BlogDTO blogDTO) {
        final Blog blog = new Blog();
        mapToEntity(blogDTO, blog);
        return blogRepository.save(blog).getId();
    }

    public void update(final Long id, final BlogDTO blogDTO) {
        final Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(blogDTO, blog);
        blogRepository.save(blog);
    }

    public void delete(final Long id) {
        blogRepository.deleteById(id);
    }

    private BlogDTO mapToDTO(final Blog blog, final BlogDTO blogDTO) {
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setDescription(blog.getDescription());
        return blogDTO;
    }

    private Blog mapToEntity(final BlogDTO blogDTO, final Blog blog) {
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        return blog;
    }

}
