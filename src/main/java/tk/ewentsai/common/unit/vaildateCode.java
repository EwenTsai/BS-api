package tk.ewentsai.common.unit;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class vaildateCode {
	private int height = 30;
	private int width = 100;

	char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	//验证码字符串
	private StringBuffer randomCode = new StringBuffer();;
	//验证码图
	private BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	public vaildateCode(){
		Graphics2D gd = buffImg.createGraphics();
		gd.setColor(Color.LIGHT_GRAY);
		gd.fillRect(0, 0, width, height);
		Font font = new Font("Fixedsys", Font.PLAIN, 23);
		// 设置字体。
		gd.setFont(font);
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);

		// 创建一个随机数生成器类
		Random random = new Random();

		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(Color.gray);
		for (int i = 0; i < 16; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}


		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < 4; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(10)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(red,green,blue));
			gd.drawString(strRand, (i + 1) * 17, 23);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getRandomCode() { return randomCode.toString(); }

	public static boolean checkCode(String sessionCode, String requestCode){
		boolean isSame = false;
		if(sessionCode.equals(requestCode)){
			isSame = true;
		}else{
			isSame = false;
		}
		return isSame;
	}
}
