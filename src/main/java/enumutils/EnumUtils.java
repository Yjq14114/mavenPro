package enumutils;


import SetUtils.TestEnity;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by ¼Ñçù on 2016/6/27.
 */
public class EnumUtils {
    public void printEnum(TestEnity enity){
        Vector vector = new Vector();
        vector.add(enity);
        Enumeration e = vector.elements();
        while(e.hasMoreElements()){
            TestEnity enity1 = (TestEnity)e.nextElement();
            String name = enity1.getName();
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        TestEnity enity = new TestEnity();
        enity.setName("mic");
        enity.setAge(23);
        enity.setMobile(1234l);
        enity.setPassword("123455");
        enity.setSex("man");
        enity.setAddress("china");
        EnumUtils enumUtils = new EnumUtils();
        enumUtils.printEnum(enity);
    }
}
