package io.gy.plat.util;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Random;


public class ValidateCodeUtil {

    public final static String SESSION_KEY = "JCCODE";
    public final static String BASE64 = "BASE64";
    public final static String IMG = "IMG";

    private final static Random RANDOM = new Random();

    /**
     * 验证码的宽
     */
    private final int width = 245;

    /**
     * 验证码的高
     */
    private final int height = 45;

    private final String randomString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZ";


    /**
     * 字体的设置
     *
     * @return Font
     */
    private Font getFont() {
        return new Font("Times New Roman", Font.PLAIN | Font.BOLD | Font.ITALIC, 40);
    }

    /**
     * 颜色的设置
     *
     * @param fc fc
     * @param bc bc
     * @return Color(r, g, b)
     */
    private static Color getRandomColor(int fc, int bc) {

        fc = Math.min(fc, 255);
        bc = Math.min(bc, 255);

        int r = fc + RANDOM.nextInt(bc - fc - 16);
        int g = fc + RANDOM.nextInt(bc - fc - 14);
        int b = fc + RANDOM.nextInt(bc - fc - 12);

        return new Color(r, g, b);
    }

    /**
     * 干扰线的绘制
     *
     * @param g Graphics
     */
    private void drawLine(Graphics g) {
        int x = RANDOM.nextInt(width);
        int y = RANDOM.nextInt(height);
        int xl = RANDOM.nextInt(20);
        int yl = RANDOM.nextInt(10);
        g.drawLine(x, y, x + xl, y + yl);

    }

    /**
     * 随机字符的获取
     *
     * @param num 0 <= num <= randomString.length()
     * @return String
     */
    private String getRandomString(int num) {
        num = num > 0 ? num : randomString.length();
        return String.valueOf(randomString.charAt(RANDOM.nextInt(num)));
    }

    /**
     * 字符串的绘制
     *
     * @param g         Graphics
     * @param randomStr 随机字符串
     * @param index     字符在字符串中下标
     */
    private void drawString(Graphics g, StringBuilder randomStr, int index) {
        g.setFont(getFont());
        g.setColor(getRandomColor(108, 190));
        String rand = getRandomString(RANDOM.nextInt(randomString.length()));
        randomStr.append(rand);
        g.translate(RANDOM.nextInt(3), RANDOM.nextInt(6));
        g.drawString(rand, 40 * index + 10, 25);
    }


    /**
     * 生成随机图片
     *
     * @param request  request
     * @param response response
     */
    public String getRandomCodeImage(HttpServletRequest request, HttpServletResponse response, String type) {
        HttpSession session = request.getSession();
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, width, height);
        g.setColor(getRandomColor(105, 189));
        g.setFont(getFont());

        // 干扰线数量
        int lineSize = 60;
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }
        // 随机字符
        StringBuilder randomStr = new StringBuilder();

        //字符数量
        int randomStrNum = 6;
        for (int i = 0; i < randomStrNum; i++) {
            drawString(g, randomStr, i);
        }
        System.out.println("随机字符：" + randomStr);
        g.dispose();
        //移除之前的session中的验证码信息
        session.removeAttribute(SESSION_KEY);
        //重新将验证码放入session
        session.setAttribute(SESSION_KEY, randomStr);
        try {
            if (IMG.equals(type)) {
                //  将图片以png格式返回,返回的是图片
                ImageIO.write(image, "PNG", response.getOutputStream());

                return null;
            } else if (BASE64.equals(type)){
                String base64String;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(image, "PNG", bos);

                byte[] bytes = bos.toByteArray();
                Base64.Encoder encoder = Base64.getEncoder();
                base64String = encoder.encodeToString(bytes);

                return base64String;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
        return null;
    }
}

