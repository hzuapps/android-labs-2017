package com.chenyirun.theircraft;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

import com.chenyirun.theircraft.inputmanagercompat.InputManagerCompat;
import com.chenyirun.theircraft.inputmanagercompat.InputManagerCompat.InputDeviceListener;
import com.chenyirun.theircraft.model.Chunk;
import com.google.vr.sdk.base.AndroidCompat;
import com.google.vr.sdk.base.GvrActivity;
import com.google.vr.sdk.base.GvrView;

/**
 * Created by chenyirun on 2017/3/6.
 */

public class Net1414080903226VRgame extends GvrActivity implements InputDeviceListener {
    public MainActivity() {
        super();
    }

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

        mRenderer = new Renderer(this.getResources());
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
    public void onCardboardTrigger() {
        vibrator.vibrate(50);
        int y = new Float(mRenderer.mPosition.y - 1.8f).intValue();
        double ChunkY = Math.floor(y / Chunk.CHUNK_SIZE);
        String s = "y=" + Float.toString(y) + "\n" +
                "ChunkY=" + Double.toString(ChunkY) + "\n" +
                "fps=" + Float.toString(mRenderer.performance.fps());
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
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
        if ((event.getSource() & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD) {
            if (event.getRepeatCount() == 0) {
                switch (keyCode){
                    case KeyEvent.KEYCODE_BUTTON_A:
                        mRenderer.jump();
                        break;
                    case KeyEvent.KEYCODE_BUTTON_X:
                        mRenderer.pressX();
                        break;
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
