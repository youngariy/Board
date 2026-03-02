package com.mjsec.board.service;

import com.mjsec.board.dto.PostRequestDto;
import com.mjsec.board.entity.Post;
import com.mjsec.board.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long create(PostRequestDto requestDto) {
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .author(requestDto.getAuthor())
                .content(requestDto.getContent())
                .build();
        return postRepository.save(post).getId();
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
    }
    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = findById(id);
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id){
        Post post = findById(id);
        postRepository.delete(post);
    }
}
