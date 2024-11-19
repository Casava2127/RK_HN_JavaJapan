package ra.example.config;
// Định nghĩa package của lớp WebConfig, giúp tổ chức các lớp trong dự án
// DispatcherServlet
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// Nhập khẩu lớp AbstractAnnotationConfigDispatcherServletInitializer từ Spring Framework,
// đây là lớp mà bạn kế thừa để cấu hình ứng dụng Spring MVC

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}




//Đăng ký DispatcherServlet cho ứng dụng.
//Liên kết DispatcherServlet với lớp cấu hình AppConfig.
//Định nghĩa các URL mà DispatcherServlet sẽ tiếp nhận.