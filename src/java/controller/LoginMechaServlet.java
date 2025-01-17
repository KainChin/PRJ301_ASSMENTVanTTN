package controller;
import dao.MechanicDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mechanic;

@WebServlet("/LoginMechaServlet")
public class LoginMechaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Lấy dữ liệu tiếng Việt
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username"); // Lấy tên người dùng từ form
            MechanicDAO mechanicDAO = new MechanicDAO();
            ArrayList<mechanic> result = mechanicDAO.getMechanic(username);

            // Nếu tìm thấy mechanic hợp lệ
            if (!result.isEmpty()) {
                // Thêm tên mechanic vào request
                mechanic mechanic = result.get(0); // Giả sử chỉ có tên trong đối tượng Mechanic
                request.setAttribute("mechanicName", mechanic.getMechanicName()); // Chỉ lưu tên

                // Chuyển hướng tới trang mechanicSuccess.jsp
                request.getRequestDispatcher("mechanicSuccess.jsp").forward(request, response);
            } else {
                // Nếu không tìm thấy mechanic hợp lệ, điều hướng tới trang báo lỗi
                response.sendRedirect("errorPageMecha.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }
}
