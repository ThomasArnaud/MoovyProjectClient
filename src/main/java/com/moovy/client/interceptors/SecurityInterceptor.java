package com.moovy.client.interceptors;

import com.moovy.client.annotations.RequiresLogin;
import com.moovy.client.entities.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Alexis Rabilloud (alexis.rabilloud@etu.univ-lyon1.fr)
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter
{
    /**
     * Tests if the user needs to be logged in.
     *
     * @param request The user's request.
     * @param response The current response.
     * @param handler The handler supposed to be called.
     * @return {@code true} if the chain of interceptors can continue, {@code false} otherwise.
     * @throws Exception If any error happens.
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
    {
        // Does the request match a controller?
        if(handler instanceof HandlerMethod)
        {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequiresLogin requiresLogin = handlerMethod.getMethodAnnotation(RequiresLogin.class);

            // Is the method annotated and does it need the user to be logged in?
            if(requiresLogin != null && requiresLogin.isRequired())
            {
                User user = (User) request.getSession().getAttribute("_user");

                // If the user isn't logged in, redirect them to the login page
                if(user == null)
                {
                    response.sendRedirect(request.getContextPath() + "/login");

                    return false;
                }
            }
        }

        return true;
    }
}
