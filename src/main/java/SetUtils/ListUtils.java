package SetUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by 佳琦 on 2016/6/25.
 */
public class ListUtils<T> {
    public void listDetail(List<T> list) throws Exception {
        for (int i=0;i<list.size();i++){
            Object obj = list.get(i);
            Map<String, Object> map = getStringObjectMap(obj);
            for (Object object :map.values()){
                System.out.println(object);
            }
            System.out.println(map);
        }

    }
    public void executeList(List<?> list)throws Exception{
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            TestEnity testEnity = (TestEnity)list.get(i);
            System.out.println(testEnity.getAge());
        }
    }

    private Map<String, Object> getStringObjectMap(Object obj) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property:propertyDescriptors){
            String key = property.getName();
            if (key.compareToIgnoreCase("class")==0){
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null?getter.invoke(obj):null;
            map.put(key,value);
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        TestEnity enity = new TestEnity();
        enity.setName("mic");
        enity.setAge(23);
        enity.setMobile(1234l);
        enity.setPassword("123455");
        enity.setSex("man");
        enity.setAddress("china");
        List<TestEnity> list = new ArrayList<TestEnity>();
        list.add(enity);
        ListUtils listUtils = new ListUtils();
        listUtils.listDetail(list);
        listUtils.executeList(list);
    }
}

