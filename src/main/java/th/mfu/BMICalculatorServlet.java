package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        Double weight = Double.parseDouble(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));

        //TODO: calculate bmi
        Double bmi = weight / (height * height);
        
        //TODO: determine the built from BMI
        if(bmi < 18.5){
            request.setAttribute("built", "underweight");
        }else if(bmi <= 25 && bmi >= 18.5){
            request.setAttribute("built", "normal");
        }else if(bmi <= 30 && bmi > 25){
            request.setAttribute("built", "overweight");
        }else if(bmi <= 35 && bmi > 30){
            request.setAttribute("built", "obese");
        }else{
            request.setAttribute("built", "wxtremely obese");}
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", Math.round(bmi));

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
           
    }
    
}
