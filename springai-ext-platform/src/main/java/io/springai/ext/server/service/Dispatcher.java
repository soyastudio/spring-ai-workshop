package io.springai.ext.server.service;

import io.springai.ext.server.session.Request;
import io.springai.ext.server.session.Session;
import io.springai.ext.server.session.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class Dispatcher {

    public String prepare(HttpServletRequest httpServletRequest) {
        Session session = SessionManager.getInstance().create(new Request(httpServletRequest));
        return session.getId();
    }

    public Session fetch(String id) {
        return SessionManager.getInstance().fetch(id);
    }
}
