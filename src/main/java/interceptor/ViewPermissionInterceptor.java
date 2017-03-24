package interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewPermissionInterceptor extends HandlerInterceptorAdapter {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
//        
//        //处理Permission Annotation，实现方法级权限控制  
//        HandlerMethod method = (HandlerMethod)handler;  
//        Permission permission = method.getMethodAnnotation(Permission.class);  
//          
//        //如果为空在表示该方法不需要进行权限验证  
//        if (permission == null) {  
//            return true;  
//        }  
//          
//        //验证是否具有权限  
//        if (!WebUtil.hasPower(request, permission.value())) {  
//            response.sendRedirect(request.getContextPath()+"/business/nopermission.html");  
//            return false;  
//        }  
//        return true;  
//          
//          
//        //注意此处必须返回true，否则请求将停止  
//        //return true;  
//    }  
}
