package io.springai.ext.server.controller;

import io.springai.ext.server.service.Dispatcher;
import io.springai.ext.server.session.Session;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ai")
public class DispatchController {

    @Autowired
    private Dispatcher dispatcher;

    @PostMapping(path = "/prepare", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> prepare(@RequestBody String input, HttpServletRequest request) {
        return ResponseEntity.ok(dispatcher.prepare(request));
    }

    @PostMapping(path = "/process", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> process(@RequestHeader String uuid, @RequestBody String input) {
        // Process or transform markdownInput
        String output = UUID.randomUUID().toString();
        return ResponseEntity.ok(output);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> fetch(@PathVariable String id) {
        Session session = dispatcher.fetch(id);
        return ResponseEntity.ok(session.getId());
    }
}

