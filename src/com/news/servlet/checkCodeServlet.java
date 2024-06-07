package com.news.servlet;

//验证码
import javax.servlet.ServletException;
import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public  class checkCodeServlet extends HttpServlet {
    //产生随机的字体
    private Font getFont(){
        //创建random对象，用于生成随机数
        Random random = new Random();
        //创建字体数组，用于封装不同字体的Font对象
        Font font[] = new Font[5];
        font[0] = new Font("Ravie", Font.PLAIN, 24);
        font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);
        font[2] = new Font("Forte", Font.PLAIN, 24);
        font[3] = new Font("Wide Latin", Font.PLAIN, 24);
        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);
        return font[random.nextInt(5)];
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        int width = 83, height = 30;
        //建立指定宽、高和BufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();//将画笔绘制于image上
        Color c= g.getColor();//保存当前画笔的颜色
        g.fillRect(0, 0, width, height);//填充矩形
        char[] ch = "abcdefghigklmnopqrstuvwxyz2345678901".toCharArray();//随机产生字符串
        int length = ch.length;//随机字符串长度
        String sRand = "";//保存随机产生的字符串
        Random random = new Random();
        for (int i=0; i<4; i++){
            g.setFont(getFont());//设置字体
            String rand = new Character(ch[random.nextInt(length)]).toString();//随机生成0~9的数字
            sRand += rand;
            //设置随机颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.drawString(rand, 20*i+6, 25);
        }
        request.getSession().setAttribute("check_code",sRand);
        //保存生成的验证码到session中
        //产生随机干扰点
        for(int i=0; i<20; i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            g.drawOval(x1, y1, 2, 2);
        }
        g.setColor(c);//重置画笔颜色
        g.dispose();//释放此图形的上下文及使用的所有系统资源
        request.getSession().setAttribute("check_code", sRand);//验证码记录到session
        ImageIO.write(image, "JPEG", os);//输出图像到页面
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
