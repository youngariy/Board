package com.mjsec.board.controller;

import com.mjsec.board.dto.PostRequestDto;
import com.mjsec.board.entity.Post;
import com.mjsec.board.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="Post API",description="게시글 CRUD를 담당하는 컨트롤러입니다.")
@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @Operation(summary ="게시글 등록",description="새로운 게시글을 작성합니다.")
    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(requestDto));
    }

    @Operation(summary ="게시글 목록 조회",description="전체 게시글 리스트를 가져옵니다.")
    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @Operation(summary ="게시글 단건 조회",description="게시글 ID를 이용하여 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @Operation(summary = "게시글 수정", description = "게시글 ID를 기준으로 기존 게시글 내용을 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return ResponseEntity.ok(postService.update(id,requestDto));
    }

    @Operation(summary = "게시글 삭제",description = "게시글 ID를 기준으로 해당 게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
