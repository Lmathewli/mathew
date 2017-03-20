package com.mathew.utils.core;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ParamUtil {

    /**
     * Returns the request parameter value as a boolean. If the parameter is
     * missing, the default value is returned.
     *
     * <p>
     * If the value is not convertible to a boolean, <code>false</code> is
     * returned.
     * </p>
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a boolean
     */
    public static boolean get(HttpServletRequest request, String param, boolean defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a Date. If the parameter is
     * missing or not convertible to a Date, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param dateFormat
     *            the format used to parse the date
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a Date
     */
    public static Date get(HttpServletRequest request, String param, DateFormat dateFormat, Date defaultValue) {

        return GetterUtil.get(request.getParameter(param), dateFormat, defaultValue);
    }

    /**
     * Returns the request parameter value as a double. If the parameter is
     * missing or not convertible to a double, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a double
     */
    public static double get(HttpServletRequest request, String param, double defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a float. If the parameter is
     * missing or not convertible to a float, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a float
     */
    public static float get(HttpServletRequest request, String param, float defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as an integer. If the parameter is
     * missing or not convertible to an integer, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as an integer
     */
    public static int get(HttpServletRequest request, String param, int defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a long. If the parameter is
     * missing or not convertible to a long, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a long
     */
    public static long get(HttpServletRequest request, String param, long defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a Number. If the parameter is
     * missing or not convertible to a Number, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a Number
     */
    public static Number get(HttpServletRequest request, String param, Number defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a short. If the parameter is
     * missing or not convertible to a short, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a short
     */
    public static short get(HttpServletRequest request, String param, short defaultValue) {

        return GetterUtil.get(request.getParameter(param), defaultValue);
    }

    /**
     * Returns the request parameter value as a String. If the parameter is
     * missing or not convertible to a String, the default value is returned.
     *
     * @param request
     *            the servlet request from which to read the parameter
     * @param param
     *            the name of the parameter
     * @param defaultValue
     *            a default value
     * @return the request parameter value as a String
     */
    public static String get(HttpServletRequest request, String param, String defaultValue) {

        String returnValue = GetterUtil.get(request.getParameter(param), defaultValue);

        if (returnValue != null) {
            return returnValue.trim();
        }

        return null;
    }
}
