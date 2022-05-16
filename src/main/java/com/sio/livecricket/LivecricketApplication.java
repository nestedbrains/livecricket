package com.sio.livecricket;

import com.sio.livecricket.entity.Blog;
import com.sio.livecricket.model.BlogDTO;
import com.sio.livecricket.repository.BlogRepository;
import com.sio.livecricket.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootApplication
public class LivecricketApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivecricketApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BlogRepository blogRepository) {
        return args -> {

            String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "Why do we use it?\n" +
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                    "\n";

            List<Blog> blogDTOS = new ArrayList<>();
            for (long i = 1; i < 20; i++) {
                blogDTOS.add(new Blog("Blog " + i, description + i, "GUID" + i));
            }

            log.info("---------------------save---------------------");
            blogRepository.saveAll(blogDTOS);
        };
    }

}
