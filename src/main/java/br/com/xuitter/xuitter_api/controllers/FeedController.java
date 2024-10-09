package br.com.xuitter.xuitter_api.controllers;

import br.com.xuitter.xuitter_api.dtos.XuitResponse;
import br.com.xuitter.xuitter_api.entities.Xuit;
import br.com.xuitter.xuitter_api.repositories.XuitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    private final XuitRepository xuitRepository;

    public FeedController(XuitRepository xuitRepository) {
        this.xuitRepository = xuitRepository;
    }

    @GetMapping("/feed")
    public List<XuitResponse> feed() {
        return xuitRepository.findAll().stream().map(XuitResponse::new).toList();
    }

}
