package 依赖倒置原则;

/**
 * @author zhengxin
 * @date 2020/11/27
 */
public class Tom {


    // bad
//    public void studyEnglish(){
//        System.out.println(" study english");
//    }
//
//    public  void studyPython(){
//        System.out.println(" study python");
//    }

    //
    public void study(ICourse iCourse){
        iCourse.study();
    }
}
