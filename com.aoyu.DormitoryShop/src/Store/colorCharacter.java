package Store;

/**
 * 输出打印带颜色字符串的方法
 */
public class colorCharacter {
     static String interceptString;
     static String addColor;
     static String swapColor;


    //输出带颜色的字符的方法
    public static void printCl(int front,int back,String type,String getCharacter) {
        if (type.equals("w")){
            interceptString=getCharacter.substring(front,back);//截取的字符
            addColor = "\033[m"+interceptString;//给截取的字符加上颜色
            swapColor = getCharacter.replace(interceptString,addColor);//将字符串里截取的字符换成加颜色的字符
            System.out.println(swapColor);
        }else if (type.equals("r")){
            interceptString=getCharacter.substring(front,back);//截取的字符
            addColor = "\033[31m"+interceptString;//给截取的字符加上颜色
            swapColor = getCharacter.replace(interceptString,addColor);//将字符串里截取的字符换成加颜色的字符
            System.out.println(swapColor);
        }else if (type.equals("y")){
            interceptString=getCharacter.substring(front,back);//截取的字符
            addColor = "\033[m"+interceptString;//给截取的字符加上颜色
            swapColor = getCharacter.replace(interceptString,addColor);//将字符串里截取的字符换成加颜色的字符
            System.out.println(swapColor);
        }else if (type.equals("b")){
            interceptString=getCharacter.substring(front,back);//截取的字符
            addColor = "\033[34m"+interceptString+"\033[m";//给截取的字符加上颜色
            swapColor = getCharacter.replace(interceptString,addColor);//将字符串里截取的字符换成加颜色的字符
            System.out.println(swapColor+"\033[m");
        }else if (type.equals("g")){
            interceptString=getCharacter.substring(front,back);//截取的字符
            addColor = "\033[32m"+interceptString;//给截取的字符加上颜色
            swapColor = getCharacter.replace(interceptString,addColor);//将字符串里截取的字符换成加颜色的字符
            System.out.println(swapColor);
        }
    }
}