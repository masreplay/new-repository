package com.enjaz.hr.util.calendar.model;

/**
 * @author Mulham-Raee
 * @since v1.2.5
 */
public class HorizontalCalendarConfig {

    public static final float DEFAULT_SIZE_TEXT_TOP = 14f;
    public static final float DEFAULT_SIZE_TEXT_MIDDLE = 24f;
    public static final float DEFAULT_SIZE_TEXT_BOTTOM = 14f;

    public static final String DEFAULT_FORMAT_TEXT_TOP = "MMMM";
    public static final String DEFAULT_FORMAT_TEXT_MIDDLE = "dd";
    public static final String DEFAULT_FORMAT_TEXT_BOTTOM = "EEE";

    /* Format & Font Sizes*/
    private String formatTopText;
    private String formatMiddleText;
    private String formatBottomText;
    private float sizeTopText;
    private float sizeMiddleText;
    private float sizeBottomText;

    private Integer selectorColor;
    private boolean showTopText;
    private boolean showBottomText;

    public HorizontalCalendarConfig() {
    }

    public HorizontalCalendarConfig(float sizeTopText, float sizeMiddleText, float sizeBottomText, Integer selectorColor) {
        this.sizeTopText = sizeTopText;
        this.sizeMiddleText = sizeMiddleText;
        this.sizeBottomText = sizeBottomText;
        this.selectorColor = selectorColor;
    }

    public String getFormatTopText() {
        return formatTopText;
    }

    public HorizontalCalendarConfig setFormatTopText(String formatTopText) {
        this.formatTopText = formatTopText;
        return this;
    }

    public String getFormatMiddleText() {
        return formatMiddleText;
    }

    public HorizontalCalendarConfig setFormatMiddleText(String formatMiddleText) {
        this.formatMiddleText = formatMiddleText;
        return this;
    }

    public String getFormatBottomText() {
        return formatBottomText;
    }

    public HorizontalCalendarConfig setFormatBottomText(String formatBottomText) {
        this.formatBottomText = formatBottomText;
        return this;
    }

    public float getSizeTopText() {
        return sizeTopText;
    }

    public HorizontalCalendarConfig setSizeTopText(float sizeTopText) {
        this.sizeTopText = sizeTopText;
        return this;
    }

    public float getSizeMiddleText() {
        return sizeMiddleText;
    }

    public HorizontalCalendarConfig setSizeMiddleText(float sizeMiddleText) {
        this.sizeMiddleText = sizeMiddleText;
        return this;
    }

    public float getSizeBottomText() {
        return sizeBottomText;
    }

    public HorizontalCalendarConfig setSizeBottomText(float sizeBottomText) {
        this.sizeBottomText = sizeBottomText;
        return this;
    }

    public Integer getSelectorColor() {
        return selectorColor;
    }

    public HorizontalCalendarConfig setSelectorColor(Integer selectorColor) {
        this.selectorColor = selectorColor;
        return this;
    }

    public boolean isShowTopText() {
        return showTopText;
    }

    public HorizontalCalendarConfig setShowTopText(boolean showTopText) {
        this.showTopText = showTopText;
        return this;
    }

    public boolean isShowBottomText() {
        return showBottomText;
    }

    public HorizontalCalendarConfig setShowBottomText(boolean showBottomText) {
        this.showBottomText = showBottomText;
        return this;
    }

    public void setupDefaultValues(HorizontalCalendarConfig defaultConfig) {
        if (defaultConfig == null) {
            return;
        }
        if (selectorColor == null) {
            selectorColor = defaultConfig.selectorColor;
        }
        if (sizeTopText == 0) {
            sizeTopText = defaultConfig.sizeTopText;
        }
        if (sizeMiddleText == 0) {
            sizeMiddleText = defaultConfig.sizeMiddleText;
        }
        if (sizeBottomText == 0) {
            sizeBottomText = defaultConfig.sizeBottomText;
        }
    }
}
