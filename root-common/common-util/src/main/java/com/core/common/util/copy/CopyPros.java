package com.core.common.util.copy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 自定义对象拷贝
 * @Date: 2020/09/18 9:17
 * @author daixu
 */
@Slf4j
public class CopyPros {

    /**
     * BeanCopier的缓存
     */
    static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();

    /**
     * 字节码转换对象属性，速度比反射快（创建新对象）
     * @param source 源对象
     * @return 拷贝后的新对象
     * @author daiux
     * @date 2021-08-12 13:39
     */
    public static<T> T copyProperties(Object source, Class<T> clazz){
        //动态创建对象
        T targets = BeanUtils.instantiateClass(clazz);
        // 构造转换器对象，最后的参数表示是否需要自定义转换器
        BeanCopier beanCopier = copy(source,targets);

        // 转换对象，自定义转换器处理特殊字段
        beanCopier.copy(source, targets, (value, target, context) -> {
            try {
                if ("Date".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 Date 类型 ------------------");
                        return CopyProsDateUtil.dateFormat(String.valueOf(value));
                    }
                }
                if ("LocalDateTime".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 LocalDateTime 类型 ------------------");
                        return CopyProsDateUtil.localDateTimeFormat(String.valueOf(value));
                    }
                }
                if ("LocalDate".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 LocalDate 类型 ------------------");
                        return CopyProsDateUtil.localDateFormat(String.valueOf(value));
                    }
                }
                if ("LocalTime".equals(target.getSimpleName())) {
                    log.info("------------------ 对象拷贝方法 字符串 转 LocalTime 类型 ------------------");
                    return CopyProsDateUtil.localTimeFormat(String.valueOf(value));
                }
                // 去重空格
                if (value instanceof String) {
                    return String.valueOf(value).trim();
                }
            }catch (Exception e){
                log.error("------------------ 对象拷贝方法异常: {} ------------------",e.getMessage());
                return null;
            }
            // 未匹配上的字段，原值返回
            return value;
        });
        return targets;
    }

    /**
     * 已有对象拷贝
     * @param source 原对象
     * @param targets 目标对象
     * @param <T> 泛型
     * @return 保留目标对象原有属性，并把源对象的属性拷贝过来
     * @author daixu
     * @date 2021-08-12 13:39
     */
    public static<T> T copyProperties(Object source, T targets){
        // 构造转换器对象，最后的参数表示是否需要自定义转换器
        BeanCopier beanCopier = copy(source,targets);
        // 转换对象，自定义转换器处理特殊字段
        beanCopier.copy(source, targets, (value, target, context) -> {
            try {
                if ("Date".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 Date 类型 ------------------");
                        return CopyProsDateUtil.dateFormat(String.valueOf(value));
                    }
                }
                if ("LocalDateTime".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 LocalDateTime 类型 ------------------");
                        return CopyProsDateUtil.localDateTimeFormat(String.valueOf(value));
                    }
                }
                if ("LocalDate".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 LocalDate 类型 ------------------");
                        return CopyProsDateUtil.localDateFormat(String.valueOf(value));
                    }
                }
                if ("LocalTime".equals(target.getSimpleName())) {
                    if (value instanceof String) {
                        log.info("------------------ 对象拷贝方法 字符串 转 LocalTime 类型 ------------------");
                        return CopyProsDateUtil.localTimeFormat(String.valueOf(value));
                    }
                }
            }catch (Exception e){
                log.error("------------------ 对象拷贝方法异常: {} ------------------",e.getMessage());
                return null;
            }
            // 未匹配上的字段，原值返回
            return value;
        });
        return targets;
    }

    /**
     * BeanCopier的copy
     * @param source 源文件的
     * @param target 目标文件
     */
    private static BeanCopier copy(Object source, Object target) {
        String key = genKey(source.getClass(), target.getClass());
        BeanCopier beanCopier;
        if (BEAN_COPIER_CACHE.containsKey(key)) {
            beanCopier = BEAN_COPIER_CACHE.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), true);
            BEAN_COPIER_CACHE.put(key, beanCopier);
        }
        return beanCopier;
    }

    /**
     * 生成key
     * @param srcClazz 源文件的class
     * @param tgtClazz 目标文件的class
     * @return string
     */
    private static String genKey(Class<?> srcClazz, Class<?> tgtClazz) {
        return srcClazz.getName() + tgtClazz.getName();
    }
}
