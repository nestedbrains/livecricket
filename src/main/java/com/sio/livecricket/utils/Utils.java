package com.sio.livecricket.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Boolean GREEN_MSG = true;

    public static void setGreenMessage(HttpServletRequest request, String message) {
        HttpSession session = request.getSession();
        List greenMessages = (List) session.getAttribute("greenMessage");
        if (greenMessages == null) {
            greenMessages = new ArrayList();
        }
        greenMessages.add(message);
        session.setAttribute("greenMessage", greenMessages);
    }

    public static Object getGreenMessage(HttpServletRequest request) {
        if (request.getSession().getAttribute("greenMessage") != null) {
            Object message = request.getSession().getAttribute("greenMessage");
            request.getSession().removeAttribute("greenMessage");
            return message;
        }
        return "";
    }
}
