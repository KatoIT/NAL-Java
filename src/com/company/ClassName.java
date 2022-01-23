package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    /**
     * Tên một lớp học hợp lệ cần đạt các yêu cầu sau:
     *  - Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
     *  - Không chứa các ký tự đặc biệt
     *  - Theo sau ký tự bắt đầu là 4 ký tự số
     *  - Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
     *
     * Ví dụ tên lớp hợp lệ: C0318G
     * Ví dụ tên lớp không hợp lệ: M0318G, P0323A
     */
    private static final String CLASS_NAME_REGEX = "^([CAP])([0-9]{4})([GHIKLM])$";

    public boolean validate(String className) {
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
}
