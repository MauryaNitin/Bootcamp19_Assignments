package com.ttn.restwithspring.restTemplateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

// Ques 8: Perform CRUD operations on the resource below using RestTemplate https://jsonplaceholder.typicode.com/posts

@RestController
public class PostController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${resource.url}")
    String url;

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id){
        ResponseEntity<Post> response = restTemplate.getForEntity(url + id, Post.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json; charset=UTF-8");
        HttpEntity<Post> request = new HttpEntity<>(new Post(1001L, 6235L, "jkdsflkajh", "slkdjfklasjdlf"), httpHeaders);
        Post post1 = restTemplate.postForObject(url,request,Post.class);
        return new ResponseEntity<Post>(post1, HttpStatus.CREATED);
    }

    @PutMapping("/posts")
    public ResponseEntity<Post> updatePost(){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(1L,1L,"title1","description1"),httpHeaders);
        return restTemplate.exchange(url,HttpMethod.PUT,request,Post.class);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Integer id){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url + id, HttpMethod.DELETE,request,Post.class);
    }
}
