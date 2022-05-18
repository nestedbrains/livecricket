package com.sio.livecricket.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Boolean GREEN_MSG = true;

    public static void setGreenMessage(HttpServletRequest request, String message) {
        HttpSession session = request.getSession();

        session.setAttribute("greenMessage", message);
    }

    public static String getGreenMessage(HttpServletRequest request) {
        if (request.getSession().getAttribute("greenMessage") != null) {
            String message = (String) request.getSession().getAttribute("greenMessage");
            request.getSession().removeAttribute("greenMessage");
            return message;
        }
        return "success";
    }
}
