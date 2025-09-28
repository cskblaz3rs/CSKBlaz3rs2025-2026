package com.ftc.cskblazers.intothedeep.components;

import android.graphics.Color;

import com.ftc.cskblazers.intothedeep.util.Scolor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Vision {

    NormalizedColorSensor colorSensor;
    public Vision(HardwareMap hardwareMap){
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "color sensor");
        if (colorSensor instanceof SwitchableLight) {
            ((SwitchableLight)colorSensor).enableLight(true);
        }
    }

    public void getColor(){
        NormalizedRGBA colors = colorSensor.getNormalizedColors();
        float[] hsvValues = new float[3];
        Color.colorToHSV(colors.toColor(), hsvValues);
        System.out.println("Red : " +  colors.red +" " +
                "Blue : " +  colors.blue +
                "Green : " +  colors.green);
        System.out.println("Hue : " +  hsvValues[0] +" " +
                            "Saturation : " +  hsvValues[1] +
                            "Value : " +  hsvValues[2]);


    }


}
