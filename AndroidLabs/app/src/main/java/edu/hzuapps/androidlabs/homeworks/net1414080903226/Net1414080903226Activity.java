package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;

import edu.hzuapps.androidlabs.R;

public class Net1414080903226Activity extends AppCompatActivity {
    private Vibrator vibrator;
    private Renderer mRenderer;
    private InputManagerCompat mInputManager;
    private InputDevice mInputDevice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeGvrView();
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        mInputManager = InputManagerCompat.Factory.getInputManager(getApplicationContext());
        mInputManager.registerInputDeviceListener(this, null);
    }

    public void initializeGvrView() {
        setContentView(R.layout.common_ui);

        GvrView gvrView = (GvrView) findViewById(R.id.gvr_view);
        //Install a config chooser which will choose a config with at least the specified depthSize
        //and stencilSize, and exactly the specified redSize, greenSize, blueSize and alphaSize.
        gvrView.setEGLConfigChooser(8, 8, 8, 8, 16, 8);

        mRenderer = new Renderer(getApplicationContext(), this.getResources());
        gvrView.setRenderer(mRenderer);

        gvrView.setTransitionViewEnabled(true);

        // Enable Cardboard-trigger feedback with Daydream headsets. This is a simple way of supporting
        // Daydream controller input for basic interactions using the existing Cardboard trigger API.
        gvrView.enableCardboardTriggerEmulation();

        if (gvrView.setAsyncReprojectionEnabled(true)) {
            // Async reprojection decouples the app framerate from the display framerate,
            // allowing immersive interaction even at the throttled clockrates set by
            // sustained performance mode.
            AndroidCompat.setSustainedPerformanceMode(this, true);
        }

        setGvrView(gvrView);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy(){
        mRenderer.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onCardboardTrigger() {
        // always give user feedback
        vibrator.vibrate(50);
        mRenderer.pressX();
    }

    @Override
    public void onInputDeviceAdded(int deviceId) {
        vibrator.vibrate(50);
        mInputDevice = InputDevice.getDevice(deviceId);
    }

    @Override
    public void onInputDeviceRemoved(int deviceId) {
        vibrator.vibrate(50);
    }

    @Override
    public void onInputDeviceChanged(int deviceId) {
        vibrator.vibrate(50);
        mInputDevice = InputDevice.getDevice(deviceId);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        int eventSource = ev.getSource();
        if ((((eventSource & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD) ||
                ((eventSource & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK))
                && ev.getAction() == MotionEvent.ACTION_MOVE) {
            int id = ev.getDeviceId();
            if (-1 != id) {
                if (mRenderer.onGenericMotionEvent(ev, mInputDevice)) {
                    return true;
                }
            }
        }
        return super.dispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
                processVolumeUp(event.getAction(), event.getRepeatCount());
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                processVolumeDown(event.getAction(), event.getRepeatCount());
                return true;
        }
        if ((event.getSource() & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD) {
            if (event.getRepeatCount() == 0) {
                switch (keyCode){
                    case KeyEvent.KEYCODE_BUTTON_A:
                    case KeyEvent.KEYCODE_BUTTON_THUMBL:
                        mRenderer.jump();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_X:
                        mRenderer.pressX();
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_B:
                        mRenderer.pressB();
                        return true;
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void processVolumeUp(int action, int repeatCount) {
        // On long press, we receive a sequence of ACTION_DOWN, ignore all after the first one.
        if (repeatCount > 0) {
            return;
        }

        switch (action) {
            case KeyEvent.ACTION_DOWN:
                mRenderer.walk(Steve.WALKING_FORWARD);
                break;
            case KeyEvent.ACTION_UP:
                mRenderer.walk(Steve.NOT_WALKING);
                break;
        }
    }

    private void processVolumeDown(int action, int repeatCount) {
        // On long press, we receive a sequence of ACTION_DOWN, ignore all after the first one.
        if (repeatCount > 0) {
            return;
        }

        switch (action) {
            case KeyEvent.ACTION_DOWN:
                mRenderer.walk(Steve.WALKING_BACKWARD);
                break;
            case KeyEvent.ACTION_UP:
                mRenderer.walk(Steve.NOT_WALKING);
                break;
        }
    }
}
