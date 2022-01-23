package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    /**
     * Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)
     *  - x là ký tự số
     *  - Không chứa các ký tự đặc biệt
     *
     * Ví dụ số điện thoại hợp lệ: (84)-(0978489648)
     * Ví dụ tên lớp không hợp lệ: (a8)-(22222222)
     */
    private static final String PHONE_NUMBER_REGEX = "^(\\()([0-9]{2})(\\)-\\()(0[0-9]{9})(\\))$";

    public boolean validate(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
