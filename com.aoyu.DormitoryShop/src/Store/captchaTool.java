package Store;

import java.util.Random;

/**
 * 验证码生成工具类
 */
public class captchaTool {

    public static String createCaptcha(int quantity){
        //定义一个空字符串用来保存生成的验证码
        String code = "";
        //将所有的字符赋值给变量allChars
        String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //导入生成随机数的包
        Random random = new Random();
        //循环生成quantity位数的随机数
        for( int i = 0; i < quantity; i++) {
            int index = random.nextInt(allChars.length());
            //将生quantity成的随机数连串起来
            code += allChars.charAt(index);

        }
        //返回生成随机数的值
        return code;
    }
}
