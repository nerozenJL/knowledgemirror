package gof.knowledgemirror.exception;

public class ExceptionHandler {



    public static void main(String[] args){
        int num1=3;
        int num2=0;
        try {//需要被检测的代码
            int result = num1 /num2 ;

        }catch (ArithmeticException e){
            //捕获异常后的处理
            System.out.println("被除数不能为0");
            e.printStackTrace();
        }finally {
            //一定会执行的代码
            System.out.println(".....");
        }
    }




    public static int div(int num1,int num2)throws Exception{
        //在功能上告诉调用者该功能可能会出现异常
        //在调用者必须处理 不处理就会出错
        return num1 /num2 ;

    }



    public void test(){


    }

}
