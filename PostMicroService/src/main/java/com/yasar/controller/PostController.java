package com.yasar.controller;

import com.yasar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yasar.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(POST)
public class PostController {
    private final PostService service;
}
