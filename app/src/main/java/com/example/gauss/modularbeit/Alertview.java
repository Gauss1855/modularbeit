package com.example.gauss.modularbeit;

import android.app.Activity;
import android.os.Bundle;
import com.example.gauss.modularbeit.ErrorMessages;
import com.example.gauss.modularbeit.ErrorMessage;

import java.util.List;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */

public class Alertview extends Activity {

    private List<ErrorMessage> errorMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertview);
    }

    /*public void timeToSolve (ErrorMessage errorMessage) {

            errorMessage.getErrorInModuleId();
            errorMessage.getErrorNumber();
            errorMessage.getErrorSolveTimeInS();
    }*/

}
