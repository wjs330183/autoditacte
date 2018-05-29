package com.kefang.autoditacte.utils;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;



public class PassWordUtil {
    /**
     *  生成 加密salt
     *
     * @return
     */
    public static String genSalt() {
        return genSalt(5);
    }

    /**
     * 生成 加密salt
     *
     * @param length  长度
     * @return
     */
    public static String genSalt(int length) {
        return UUID.randomUUID().toString().substring(0, length);
    }

    /**
     *  MD5  + salt 加密， 不可解密
     *
     * @param passStr
     * @param passSalt
     * @return
     */
    public static String encrypt(String passStr, String passSalt) {

        return new Md5Hash(passStr, passSalt).toString();
    }


    /**
     *  登陆验证
     *
     * @param passStr
     * @param passLogin
     * @param salt
     * @return
     */
    public static boolean validate(String passStr, String passLogin ,String salt) {

        return passStr.equals(encrypt(passLogin, salt));
    }

    /**
     * 正则表达式验证密码必须要包含数字和大小写字母的6-20位密码
     * @param input
     * @return
     */
    public static boolean rexCheckPassword(String input) {
        // 6-20 位，字母、数字、字符
        //String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        //String regStr = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$"; //2017-05-26 18:44 替换
        String regStr = "^([A-Z]|[a-z]|[0-9]|[~!@#$%^&*\\(\\)_+\\{\\}\\|:”<>?`\\[\\]\\-\\\\=;’,./]){6,16}$";
        return input.matches(regStr);
    }
    private static final String HEX_NUMS_STR="0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 12;




}
