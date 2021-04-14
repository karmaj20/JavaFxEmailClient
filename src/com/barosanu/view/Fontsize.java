package com.barosanu.view;

public enum Fontsize {
    SMALL,
    MEDIUM,
    BIG;

    public static String getCssPath(Fontsize fontsize) {
        switch (fontsize) {
            case MEDIUM:
                return "css/fontMedium.css";
            case BIG:
                return "css/fontBig.css";
            case SMALL:
                return "css/fontSmall.css";
            default:
                return null;
        }
    }
}
