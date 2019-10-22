package com.edgedo.sys.utils;

import com.edgedo.sys.queryvo.ScaleUserOrderView;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Map2ObjectUtil {


    /**
     * 〈map 转 自定义实体类 自定义工具类〉
     *
     * @author Zy0116
     * @create 2018/11/16
     * @since 1.0.0
     */
    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {

        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();

            // 获取自定义clazz类的全部字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {

                // 获取字段修饰符 需要排除静态及final修饰的字段
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                // 强制设置为 true 即可以对字段值进行设置 防止一些方法阻碍我们对属性进行赋值
                field.setAccessible(true);

                // map 中如果包含字段名称的 key 则将对应的值放入 clazz 对象对应的字段上
                if (map.containsKey(field.getName())) {
                    field.set(obj, map.get(field.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 将 Map对象转化为JavaBean
     *
     * @param map
     * @param T
     * @return
     * @throws Exception
     */
    public static <T> T convertMap2Bean(Map<String, Object> map, Class<T> T)
            throws Exception {
        if (map == null || map.size() == 0) {
            return null;
        }
        //获取map中所有的key值，全部更新成大写，添加到keys集合中,与mybatis中驼峰命名匹配
        Object mvalue = null;
        Map<String, Object> newMap = new HashMap<>();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            mvalue = map.get(key);
          /*  if (key.indexOf(CharacterConstant.UNDERLINE) != -1)
            {
                key = key.replaceAll(CharacterConstant.UNDERLINE, "");
            }*/
            newMap.put(key.toUpperCase(Locale.US), mvalue);
        }

        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = T.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            String upperPropertyName = propertyName.toUpperCase();

            if (newMap.keySet().contains(upperPropertyName)) {
                Object value = newMap.get(upperPropertyName);
                //这个方法不会报参数类型不匹配的错误。
                BeanUtils.copyProperty(bean, propertyName, value);
            }
        }
        return bean;
    }

    public static <T> List<T> convertListMap2ListBean(List<Map<String, Object>> listMap, Class<T> T)
            throws Exception {
        List<T> beanList = new ArrayList<>();
        if (listMap != null && !listMap.isEmpty()) {
            for (int i = 0, n = listMap.size(); i < n; i++) {
                Map<String, Object> map = listMap.get(i);
                T bean = convertMap2Bean(map, T);
                beanList.add(bean);
            }
            return beanList;
        }
        return beanList;
    }

    /**
     * map 转化为对象
     *
     * @param map    需要转化的参数
     * @param aClass 要转化成的对象
     * @return 转化成功的对象
     * @throws IllegalAccessException 非法访问异常
     * @throws InstantiationException 实例化异常
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> aClass) throws IllegalAccessException, InstantiationException {
        if (null == map || map.size() <= 0) {
            return null;
        }
        Object o = aClass.newInstance();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers)) {
                continue;
            }
            // （此处如果不设置 无法获取对象的私有属性）
            field.setAccessible(true);
            field.set(o, map.get(field.getName()));
        }
        return o;
    }

    /**
     * 利用反射将map集合封装成bean对象
     *
     * @param params
     * @param clazz
     * @return
     */
    /**
     * 利用反射将map集合封装成bean对象
     *
     * @param params
     * @param clazz
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {
        Object obj = clazz.newInstance();
        if (map != null && !map.isEmpty() && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();    // 属性名
                Object value = entry.getValue();        // 属性值
                String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);    //获取和map的key匹配的属性名称
                if (field == null) {
                    continue;
                }
                Class<?> fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) obj;
    }

    /**
     * 根据给定对象类匹配对象中的特定字段
     *
     * @param clazz
     * @param fieldName
     * @return
     */
    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> superClass = clazz.getSuperclass();    //如果该类还有父类，将父类对象中的字段也取出
        if (superClass != null) {                        //递归获取
            return getClassField(superClass, fieldName);
        }
        return null;
    }

    /**
     * 将map的value值转为实体类中字段类型匹配的方法
     *
     * @param value
     * @param fieldTypeClass
     * @return
     */
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;

        if (Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if (Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if (Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if (Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;

    }
    public static <T> T mapToBean(Map<String, Object> map,T bean){
        BeanMap beanMap=BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}

