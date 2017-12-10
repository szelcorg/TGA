package org.szelc.fit.garmin;

import com.garmin.fit.Field;
import com.garmin.fit.Profile;



public class FitField extends Field {

    public FitField(Field field) {
        super(field);
    }

    public FitField(String s, int i, int i1, double v, double v1, String s1, boolean b) {
        super(s, i, i1, v, v1, s1, b);
    }

    @Override
    public String toString() {
        return "FitField{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", type=" + type +
                ", scale=" + scale +
                ", offset=" + offset +
                ", units='" + units + '\'' +
                ", isAccumulated=" + isAccumulated +
                ", components=" + components +
                ", subFields=" + subFields +
                ", values=" + values +
                '}';
    }
}
