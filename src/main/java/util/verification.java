package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具类
 * @author dell
 *
 */
public class verification {
	private Random random = new Random();
	/**
	 * 随机结果
	 */
	public Object[] RandomCount(){
		//定义运算符
		char[] operate = {'+','-','*','/'};
		//随机第一个数   1-10
		int num1 = 1+random.nextInt(9);
		//随机运算符
		int oper = random.nextInt(4);//0-4 不包含4
		//随机第二个数字
		int num2 = 1+random.nextInt(9);
		//结果
		int result = 0;
		switch(oper){
			case 0:
				result = num1 + num2;
				break;
			case 1:
				result = num1 - num2;
				break;
			case 2:
				result = num1 * num2;
				break;
			case 3:
				result = num1 / num2;
				break;
		}
		BufferedImage image = DrawPic(num1,num2,oper,operate);
		Object[] obj = new Object[] {result,image}; 
		return obj;
				
	}
	/**
	 * 画图
	 * 
	 * 
	 */
	public BufferedImage DrawPic(int num1,int num2,int oper,char[] operate){
		int width = 60 ,height = 25;
		//产生图片画板
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//取得制图工具
		Graphics graphics = image.getGraphics();
		//设置颜色
		graphics.setColor(getRandomColor(200,250));
		//矩形
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(new Font("Times new Roman",Font.ROMAN_BASELINE,20));
		graphics.setColor(getRandomColor(160, 200));
		//画干扰线
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			graphics.drawLine(x, y, x1, y1);
		}
		//设置验证表达式的颜色
		graphics.setColor(getRandomColor(20, 130));
		//画之
		String content = num1+" "+operate[oper]+" "+num2+"=";
		graphics.drawString(content, 5, 20);
		//释放资源
		graphics.dispose();
		return image;
	}
	/**
	 * 随机颜色
	 * @param a
	 * @param b
	 * @return
	 */
	public Color getRandomColor(int a,int b) {
		Random random = new Random();
		a = a > 255 ? 255 : a;
		b = b > 255 ? 255 : b;
		int red = a + random.nextInt(b - a);
		int blue = a + random.nextInt(b - a);
		int green = a + random.nextInt(b - a);
		
		return new Color(red,green,blue);
	}
}
