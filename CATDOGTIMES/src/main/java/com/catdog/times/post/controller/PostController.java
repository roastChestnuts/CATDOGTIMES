package com.catdog.times.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.catdog.times.post.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PostController {
	@Autowired
	private PostService service;
}
