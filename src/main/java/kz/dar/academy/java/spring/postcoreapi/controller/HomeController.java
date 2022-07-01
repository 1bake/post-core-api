package kz.dar.academy.java.spring.postcoreapi.controller;

import kz.dar.academy.java.spring.postcoreapi.models.PostModel;
import kz.dar.academy.java.spring.postcoreapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    @RestController
    @RequestMapping("/post")
    public class HomeController {

        @Autowired
        private PostService postService;

        @Autowired
        Environment env;

        @GetMapping("/check")
        public String check(){
            return "Post-core-api is working"+env.getProperty("local.server.port");
        }

        @PostMapping
        public PostModel createPost(@Valid @RequestBody PostModel postModel) {
            return postService.createPost(postModel);
        }

        @RequestMapping(name="")

        @GetMapping("/all")
        public List<PostModel> getAllPosts() {
            return postService.getAllPosts();
        }

        @GetMapping("/{postId}")
        public PostModel getPostById(@PathVariable String postId) {
            return postService.getPostById(postId);
        }

        @PutMapping("/{postId}")
        public PostModel updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
            return postService.updatePost(postId, postModel);
        }

        @DeleteMapping("/{postId}")
        public ResponseEntity<String> deletePostById(@PathVariable String postId) {
            postService.deletePostById(postId);
            return new ResponseEntity<>("Success deleted", HttpStatus.OK);
        }

    }
