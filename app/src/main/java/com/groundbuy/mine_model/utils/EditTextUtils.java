package com.groundbuy.mine_model.utils;

import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.text.method.NumberKeyListener;
import android.widget.EditText;

import androidx.annotation.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class EditTextUtils {

//
//    /**
//     * 设置只能输入金额格式
//     */
//    public static void editAmount(EditText editText) {
//        editText.setFilters (new InputFilter[]{new MoneyValueFilter ()});
//    }

    /**
     * 只能输入电话
     */
    public static void editPhone(EditText editText) {
        editText.setKeyListener (new NumberKeyListener () {
            @Override
            public int getInputType() {

                return InputType.TYPE_CLASS_NUMBER;
            }

            @NonNull
            @Override
            protected char[] getAcceptedChars() {
                char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-'};
                return chars;
            }
        });

    }

    public static void editNumberStr(EditText editText) {
        editText.setKeyListener (new NumberKeyListener() {
            @Override
            protected char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e',
                        'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            }

            @Override
            public int getInputType() {
                return InputType.TYPE_CLASS_TEXT;
            }
        });
    }

//    /**
//     * 不能输入表情
//     */
//    public static void editEmoji(EditText editText) {
//        editText.setFilters (new InputFilter[]{new EmojiFilter ()});
//
//    }

//    /**
//     * 中文32位，英文就1位来算，通常用于昵称等 默认16个
//     */
//    public static void editChinese(EditText editText) {
//        editText.setFilters (new InputFilter[]{new ChineseFilter ()});
//    }

    /**
     * 自定义
     * 中文32位，英文就1位来算，通常用于昵称等 可以设置几位字符，比如32，那中文就是16，英文就是32，如果中英混合 如 中文10个，就是20个字符，这时候英文还能输入12个字符，一个汉字占两个字符，一个字母占一个字符。
     */
//    public static void editChineseValue(EditText editText, int value) {
//        editText.setFilters (new InputFilter[]{new ChineseFilter (value)});
//
//    }

    /**
     * 只能输入什么类型的字符
     */
    public static void digistsNumberLetter(EditText editText) {
        String digists = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-";
        editText.setKeyListener (DigitsKeyListener.getInstance (digists));
    }

    /**
     * 中国身份证类型，
     */
    public static void editIdNumber(EditText editText) {
        editText.setKeyListener (new NumberKeyListener () {
            @Override
            public int getInputType() {

                return InputType.TYPE_CLASS_NUMBER;
            }

            @NonNull
            @Override
            protected char[] getAcceptedChars() {
                char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'X', 'x'};
                return chars;
            }
        });
    }

    /**
     * 只有字母没有其它的
     */
    public static void digistsLetter(EditText editText) {
        String digists = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        editText.setKeyListener (DigitsKeyListener.getInstance (digists));
    }

    /*  判断字符串是否全是数字*/
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile ("[0-9]*");
        Matcher isNum = pattern.matcher (str);
        if (!isNum.matches ()) {
            return false;
        }
        return true;
    }

    /*  判断是否全是英文*/
    public static boolean isEnglish(String str) {

        return str.matches ("[a-zA-Z]+");//true:全文英文
    }

    public static boolean isPasswordComplexity(String password) {
        String regex = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{8,20}$";
        return testRegex (regex, password);
    }

    public static boolean testRegex(String regex, String inputValue) {
        return Pattern.compile (regex).matcher (inputValue).matches ();
    }


}
