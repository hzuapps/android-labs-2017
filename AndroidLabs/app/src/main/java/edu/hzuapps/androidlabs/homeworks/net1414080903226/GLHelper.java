package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;

import com.chenyirun.theircraft.model.Buffers;
import com.chenyirun.theircraft.model.Point3;
import com.chenyirun.theircraft.model.Point3Int;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

class GLHelper {
    private static final String TAG = "GLHelper";

    private int blockProgram;
    private int lineProgram;
    private int pointProgram;

    public final float[] modelBlock = new float[16];
    private final float[] modelView = new float[16];
    private final float[] modelViewProjection = new float[16];

    private int textureHandle;
    private int textureData;
    private int blockPositionParam;
    private int blockUVParam;
    private int blockModelViewProjectionParam;
    private int linePositionParam;
    private int lineModelViewProjectionParam;
    private int pointPositionParam;
    private int pointModelViewProjectionParam;

    private static final int COORDS_PER_VERTEX = 3;
    private static final int VERTEX_STRIDE = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

    private static final String BlockVertexShader =
            "uniform mat4 u_MVP;\n" +
                    "attribute vec4 a_Position;\n" +
                    "attribute vec2 a_textureCoord;\n" +
                    "varying vec2 v_textureCoord;\n" +
                    "\n" +
                    "void main() {\n" +
                    "   gl_Position = u_MVP * a_Position;\n" +
                    "   v_textureCoord = a_textureCoord;\n" +
                    "}";

    private static final String BlockFragmentShader =
            "precision mediump float;\n" +
                    "uniform sampler2D u_texture;\n" +
                    "varying vec2 v_textureCoord;\n" +
                    "\n" +
                    "void main() {\n" +
                    "    gl_FragColor = texture2D(u_texture, v_textureCoord);\n" +
                    "}";

    private static final String LineVertexShader =
            "uniform mat4 u_MVP;\n" +
            "attribute vec4 a_Position;\n" +
            "\n" +
            "void main() {\n" +
            "    gl_Position = u_MVP * a_Position;\n" +
            "}\n";

    private static final String LineFragmentShader =
            "void main() {\n" +
            "    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n" +
            "}\n";

    private static final String PointVertexShader =
            "uniform mat4 u_MVP;\n" +
                    "attribute vec4 a_Position;\n" +
                    "\n" +
                    "void main() {\n" +
                    "    gl_Position = u_MVP * a_Position;\n" +
                    "}\n";

    private static final String PointFragmentShader =
            "void main() {\n" +
                    "    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);\n" +
                    "}\n";

    public void attachVariables(Resources resources){
        blockProgram = GLHelper.linkProgram(BlockVertexShader, BlockFragmentShader);
        lineProgram = GLHelper.linkProgram(LineVertexShader, LineFragmentShader);
        pointProgram = GLHelper.linkProgram(PointVertexShader, PointFragmentShader);

        textureData = GLHelper.loadTexture(resources, R.drawable.texture);
        textureHandle = GLES20.glGetUniformLocation(blockProgram, "u_texture");

        blockUVParam = GLES20.glGetAttribLocation(blockProgram, "a_textureCoord");
        blockPositionParam = GLES20.glGetAttribLocation(blockProgram, "a_Position");
        blockModelViewProjectionParam = GLES20.glGetUniformLocation(blockProgram, "u_MVP");
        linePositionParam = GLES20.glGetAttribLocation(lineProgram, "a_Position");
        lineModelViewProjectionParam = GLES20.glGetUniformLocation(lineProgram, "u_MVP");
        pointPositionParam = GLES20.glGetAttribLocation(lineProgram, "a_Position");
        pointModelViewProjectionParam = GLES20.glGetUniformLocation(lineProgram, "u_MVP");
    }

    public void computeMVP(float[] view, float[] perspective){
        Matrix.setIdentityM(modelBlock, 0);
        Matrix.multiplyMM(modelView, 0, view, 0, modelBlock, 0);
        Matrix.multiplyMM(modelViewProjection, 0, perspective, 0, modelView, 0);
    }

    public void beforeDrawBlocks(){
        GLES20.glUseProgram(blockProgram);
        GLES20.glUniform1i(textureHandle, 0);
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureData);

        GLES20.glUniformMatrix4fv(blockModelViewProjectionParam, 1, false, modelViewProjection, 0);

        GLES20.glEnableVertexAttribArray(blockPositionParam);
        GLES20.glEnableVertexAttribArray(blockUVParam);
    }

    public void drawBlocks(Buffers buffers){
        GLES20.glVertexAttribPointer(blockPositionParam, 3, GLES20.GL_FLOAT, false, 0, buffers.vertexBuffer);
        GLES20.glVertexAttribPointer(blockUVParam, 2, GLES20.GL_FLOAT, false, 0, buffers.textureCoordBuffer);

        GLES20.glDrawElements(
                GLES20.GL_TRIANGLES, buffers.drawListBuffer.limit(),
                GLES20.GL_UNSIGNED_SHORT, buffers.drawListBuffer);
    }

    public void afterDrawBlocks(){
        GLES20.glDisableVertexAttribArray(blockPositionParam);
        GLES20.glDisableVertexAttribArray(blockUVParam);
    }

    static final float positions[][] = {
        {-0.5f, -0.5f, -0.5f},
        {-0.5f, -0.5f, +0.5f},
        {-0.5f, +0.5f, -0.5f},
        {-0.5f, +0.5f, +0.5f},
        {+0.5f, -0.5f, -0.5f},
        {+0.5f, -0.5f, +0.5f},
        {+0.5f, +0.5f, -0.5f},
        {+0.5f, +0.5f, +0.5f}
    };
    static final int indices[] = {
            0, 1, 0, 2, 0, 4, 1, 3,
            1, 5, 2, 3, 2, 6, 3, 7,
            4, 5, 4, 6, 5, 7, 6, 7
    };

    private float[] genWireFrame(Point3Int pos){
        float[] result = new float[72];
        for (int i = 0; i < 24; i++) {
            int j = indices[i];
            result[i*3] = pos.x +  positions[j][0];
            result[i*3+1] = pos.y +  positions[j][1];
            result[i*3+2] = pos.z +  positions[j][2];
        }
        return result;
    }

    public void drawWireFrame(Point3Int pos){
        float[] wireFrameCoords = genWireFrame(pos);
        drawLines(wireFrameCoords);
    }

    public void drawSightVector(Point3 sightVector, Point3 pos){
        Point3 sv = sightVector.times(3);
        float[] coords = {
                pos.x , pos.y, pos.z,
                //pos.x + sv.x * ratio, pos.y + sv.y * ratio, pos.z + sv.z * ratio,
                pos.x + sv.x, pos.y + sv.y, pos.z + sv.z
        };
        drawLines(coords);
    }
/*
    public void drawCrossHair(){
        float[] coords = {
                1920 / 2.0f, 1080.0f / 2.0f,
        };
        drawPoints(coords, 2);
    }
*/
    private static final float[] pointMatrix = {
            2 / 1920.0f, 0, 0, 0,
            0, 2 / 1080.0f, 0, 0,
            0, 0, -1, 0,
            -1, -1, 0, 1
    };
    public void drawPoints(float[] pointCoords, int coordsPerVertex) {
        ByteBuffer bb = ByteBuffer.allocateDirect(pointCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer VertexBuffer = bb.asFloatBuffer();
        VertexBuffer.put(pointCoords);
        VertexBuffer.position(0);

        GLES20.glUseProgram(pointProgram);
        GLES20.glEnableVertexAttribArray(pointPositionParam);
        GLES20.glVertexAttribPointer(pointPositionParam, coordsPerVertex, GLES20.GL_FLOAT, false, coordsPerVertex * 4, VertexBuffer);
        GLES20.glUniformMatrix4fv(pointModelViewProjectionParam, 1, false, pointMatrix, 0);
        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, pointCoords.length / coordsPerVertex);
        GLES20.glDisableVertexAttribArray(pointPositionParam);
    }

    public void drawLines(float[] lineCoords) {
        ByteBuffer bb = ByteBuffer.allocateDirect(lineCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer VertexBuffer = bb.asFloatBuffer();
        VertexBuffer.put(lineCoords);
        VertexBuffer.position(0);

        GLES20.glUseProgram(lineProgram);
        GLES20.glLineWidth(3);
        GLES20.glEnableVertexAttribArray(linePositionParam);
        GLES20.glVertexAttribPointer(linePositionParam, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, VERTEX_STRIDE, VertexBuffer);
        GLES20.glUniformMatrix4fv(lineModelViewProjectionParam, 1, false, modelViewProjection, 0);
        GLES20.glDrawArrays(GLES20.GL_LINES, 0, lineCoords.length / COORDS_PER_VERTEX);
        GLES20.glDisableVertexAttribArray(linePositionParam);
    }

    private static final int FLOAT_SIZE_IN_BYTES = 4;

    static FloatBuffer createFloatBuffer(float[] from) {
        FloatBuffer result = ByteBuffer.allocateDirect(FLOAT_SIZE_IN_BYTES * from.length)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        result.put(from)
                .position(0);
        return result;
    }

    private static final int SHORT_SIZE_IN_BYTES = 2;

    static ShortBuffer createShortBuffer(short[] from) {
        ShortBuffer result = ByteBuffer.allocateDirect(SHORT_SIZE_IN_BYTES * from.length)
                .order(ByteOrder.nativeOrder())
                .asShortBuffer();
        result.put(from)
                .position(0);
        return result;
    }

    /**
     * @param type  Must be one of GLES20.GL_VERTEX_SHADER or GLES20.GL_FRAGMENT_SHADER).
     */
    private static int loadShader(int type, String glsl) {
        if (type != GLES20.GL_VERTEX_SHADER && type != GLES20.GL_FRAGMENT_SHADER) {
            Exceptions.failIllegalArgument("Unsupported shader type %d", type);
        }

        int shader = GLES20.glCreateShader(type);
        if (shader == 0) {
            Exceptions.fail("Failed to create a shader of type %d", type);
        }

        GLES20.glShaderSource(shader, glsl);
        GLES20.glCompileShader(shader);

        // Get compilation status.
        int[] status = new int[] { GLES20.GL_FALSE };
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, status, 0);
        if (status[0] == GLES20.GL_FALSE) {
            GLES20.glGetShaderiv(shader, GLES20.GL_INFO_LOG_LENGTH, status, 0);
            Log.e(TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(shader));
            GLES20.glDeleteShader(shader);
            Exceptions.fail("Failed to compile a shader of type %d, status: %d", type, status[0]);
        }

        return shader;
    }

    static int linkProgram(String vertexShaderGlsl, String fragmentShaderGlsl) {
        int vertexShader = GLHelper.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderGlsl);
        int fragmentShader = GLHelper.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderGlsl);

        int program = GLES20.glCreateProgram();
        if (program == 0) {
            throw new RuntimeException("Failed to create a program");
        }

        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);

        // Get link status.
        int[] status = new int[] { GLES20.GL_FALSE };
        GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, status, 0);
        if (status[0] == GLES20.GL_FALSE) {
            GLES20.glGetProgramiv(program, GLES20.GL_INFO_LOG_LENGTH, status, 0);
            Log.e(TAG, "Error compiling program: " + GLES20.glGetProgramInfoLog(program));
            GLES20.glDeleteProgram(program);
            throw new RuntimeException("Failed to link program");
        }

        GLES20.glDeleteShader(vertexShader);
        GLES20.glDeleteShader(fragmentShader);
        return program;
    }

    static int loadTexture(Resources resources, int resourceId) {
        int textureHandles[] = new int[1];
        GLES20.glGenTextures(1, textureHandles, 0);
        if (textureHandles[0] == 0) {
            throw new RuntimeException("Failed to create a texture");
        }
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandles[0]);

        Bitmap bitmap = loadBitmap(resources, resourceId);
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();

        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);

        return textureHandles[0];
    }

    private static Bitmap loadBitmap(Resources resources, int resourceId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;   // No pre-scaling
        Bitmap original = BitmapFactory.decodeResource(resources, resourceId, options);
        if (original == null) {
            Exceptions.fail("Failed to decode bitmap from resource %d", resourceId);
        }
        Bitmap processed = setBackgroundTransparent(original, 0xFFFF00FF);
        return processed;
    }

    public static Bitmap setBackgroundTransparent(Bitmap bitmap,int backgroundColor) {
        if (bitmap != null) {
            int picw = bitmap.getWidth();
            int pich = bitmap.getHeight();
            int[] pix = new int[picw * pich];
            bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich);
            for (int y = 0; y < pich; y++) {
                for (int x = 0; x < picw; x++) {
                    int index = y * picw + x;
                    if (pix[index] == backgroundColor){
                        pix[index] = Color.TRANSPARENT;
                    }
                }
            }
            Bitmap bm = Bitmap.createBitmap(pix, picw, pich,Bitmap.Config.ARGB_8888);
            return bm;
        }
        return null;
    }

    public static void drawBackground(){
        GLES20.glClearColor(0.5f, 0.69f, 1.0f, 1.0f);
    }

    public static void beforeDraw(){
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glDepthFunc(GLES20.GL_LEQUAL);
        GLES20.glFrontFace(GLES20.GL_CCW);
        GLES20.glEnable(GLES20.GL_CULL_FACE);
        GLES20.glCullFace(GLES20.GL_BACK);

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
    }
}
