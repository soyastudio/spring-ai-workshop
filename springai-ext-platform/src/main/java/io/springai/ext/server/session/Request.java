package io.springai.ext.server.session;

import jakarta.servlet.http.HttpServletRequest;

public class Request {

    private final HttpServletRequest httpServletRequest;

    public Request(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
}
