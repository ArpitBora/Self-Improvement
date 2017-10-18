package com.arpit.poc.selfimprovement.core.servlets;

import java.io.IOException;

import javax.jcr.Repository;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

@SuppressWarnings("serial")
@SlingServlet(resourceTypes = { "selfimprovement/components/structure/page" },
              selectors = { "data" },
              extensions = { "html" },
              methods = { "GET" },
              metatype = false)
public class SlingServletUsingResourceTypeSelector extends SlingAllMethodsServlet {
    @Reference
    private Repository repository;

    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String[] keys = this.repository.getDescriptorKeys();
        JSONObject jsonobject = new JSONObject();

        for (int i = 0; i < keys.length; i++) {
            try {
                jsonobject.put(keys[i], this.repository.getDescriptor(keys[i]));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        resp.getWriter().println(jsonobject.toString());
    }

    protected void bindRepository(Repository paramRepository) {
        this.repository = paramRepository;
    }

    protected void unbindRepository(Repository paramRepository) {
        if (this.repository == paramRepository) {
            this.repository = null;
        }
    }
}
