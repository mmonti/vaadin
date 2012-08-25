package ar.mmonti.wcm.support;

import com.vaadin.terminal.Sizeable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mauro.monti
 */
public class Dimensions {

    private static final Logger logger = LoggerFactory.getLogger(Dimensions.class);

    public final static float VALUE_0 = 0;
    public final static float VALUE_10 = 10;
    public final static float VALUE_20 = 20;
    public final static float VALUE_30 = 30;
    public final static float VALUE_40 = 40;
    public final static float VALUE_50 = 50;
    public final static float VALUE_60 = 60;
    public final static float VALUE_70 = 70;
    public final static float VALUE_80 = 80;
    public final static float VALUE_90 = 90;
    public final static float VALUE_100 = 100;
    public final static float VALUE_150 = 150;
    public final static float VALUE_180 = 180;
    public final static float VALUE_200 = 200;
    public final static float VALUE_220 = 220;
    public final static float VALUE_230 = 230;
    public final static float VALUE_240 = 240;
    public final static float VALUE_250 = 250;
    public final static float VALUE_260 = 260;
    public final static float VALUE_280 = 280;
    public final static float VALUE_300 = 300;
    public final static float VALUE_320 = 320;
    public final static float VALUE_350 = 350;
    public final static float VALUE_360 = 360;
    public final static float VALUE_380 = 380;
    public final static float VALUE_400 = 400;
    public final static float VALUE_420 = 420;
    public final static float VALUE_450 = 450;
    public final static float VALUE_480 = 480;

    /**
     * @param value
     * @param unit
     * @return
     */
    public static String getSize(float value, int unit) {
        final String sizeUnit = Sizeable.UNIT_SYMBOLS[unit];

        return value + sizeUnit;
    }

    /**
     * @param value
     * @return
     */
    public static int getSize(float value) {
        return Float.valueOf(value).intValue();
    }
}

