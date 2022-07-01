package kz.dar.academy.java.spring.postcoreapi.services;

import kz.dar.academy.java.spring.postcoreapi.models.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private static HashMap<String,PostModel> postMap = new HashMap<>();

    static {

        PostModel post1 = new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),"ivan@mail.ru","Ivan","iphone","active");
        PostModel post2 = new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),"sergei@mail.ru","Sergei","iphone","active");
        PostModel post3 = new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),"natawa@mail.ru","Natawa","iphone","passive");
        PostModel post4 = new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),"berik@mail.ru","Berik","iphone","active");
        PostModel post5 = new PostModel(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString(),"serik@mail.ru","Serik","iphone","passive");

        postMap.put(post1.getPostId(),post1);
        postMap.put(post2.getPostId(),post2);
        postMap.put(post3.getPostId(),post3);
        postMap.put(post4.getPostId(),post4);
        postMap.put(post5.getPostId(),post5);

    }

    @Override
    public PostModel createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        return postMap.put(postModel.getPostId(),postModel);
    }

    @Override
    public PostModel updatePost(String postId,PostModel postModel) {
        postModel.setPostId(postId);
        return postMap.put(postId,postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void deletePostById(String postId) {

        postMap.remove(postId);

    }
}
