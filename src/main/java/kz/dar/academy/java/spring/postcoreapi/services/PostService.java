package kz.dar.academy.java.spring.postcoreapi.services;

import kz.dar.academy.java.spring.postcoreapi.models.PostModel;

import java.util.List;

public interface PostService {
    PostModel createPost(PostModel postModel);
    PostModel updatePost(String postId,PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    void deletePostById(String postId);
}
