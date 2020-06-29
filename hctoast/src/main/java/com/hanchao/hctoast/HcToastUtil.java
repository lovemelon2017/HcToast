package com.hanchao.hctoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

import java.lang.reflect.Method;

public class HcToastUtil {

    private static int sGravity = -1;
    private static int sXOffset = -1;
    private static int sYOffset = -1;
    private static int sBgColor = Color.BLACK;
    private static int sBgResource = -1;
    private static int sMsgColor = Color.WHITE;
    private static int sMsgTextSize = -1;
    private static Toast toast;


    private static Context applicationContext = null;


    public static void showShort(String message) {

        if (toast != null) {
            toast.cancel();
            toast = null;
        }

        toast = new Toast(getApplicationContext());
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.toast_layout, null);
        TextView tvMessage = view.findViewById(R.id.message);
        if (sBgResource != -1) {
            tvMessage.setBackgroundResource(sBgResource);
        } else if (sBgColor != Color.BLACK) {
            GradientDrawable gradientDrawable = (GradientDrawable) tvMessage.getBackground();
            gradientDrawable.setColor(sBgColor);
        }

        tvMessage.setText(message);

        if (sGravity != -1 || sXOffset != -1 || sYOffset != -1) {
            toast.setGravity(sGravity, sXOffset, sYOffset);
        }
        if (sMsgTextSize != -1) {
            tvMessage.setTextSize(sMsgTextSize);
        }
        tvMessage.setTextColor(sMsgColor);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();


    }

    public static void showLong(String message) {

        if (toast != null) {
            toast.cancel();
            toast = null;
        }

        toast = new Toast(getApplicationContext());
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.toast_layout, null);
        TextView tvMessage = view.findViewById(R.id.message);
        if (sBgResource != -1) {
            tvMessage.setBackgroundResource(sBgResource);
        } else if (sBgColor != Color.BLACK) {
            GradientDrawable gradientDrawable = (GradientDrawable) tvMessage.getBackground();
            gradientDrawable.setColor(sBgColor);
        }

        tvMessage.setText(message);

        if (sGravity != -1 || sXOffset != -1 || sYOffset != -1) {
            toast.setGravity(sGravity, sXOffset, sYOffset);
        }
        if (sMsgTextSize != -1) {
            tvMessage.setTextSize(sMsgTextSize);
        }
        tvMessage.setTextColor(sMsgColor);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();


    }

    public static void showCustom(String message, View view) {

        if (toast != null) {
            toast.cancel();
            toast = null;
        }

        toast = new Toast(getApplicationContext());
        TextView tvMessage = view.findViewById(R.id.message);
        if (tvMessage == null) {
            return;
        }
        if (sBgResource != -1) {
            tvMessage.setBackgroundResource(sBgResource);
        } else if (sBgColor != Color.BLACK) {
            GradientDrawable gradientDrawable = (GradientDrawable) tvMessage.getBackground();
            gradientDrawable.setColor(sBgColor);
        }

        tvMessage.setText(message);

        if (sGravity != -1 || sXOffset != -1 || sYOffset != -1) {
            toast.setGravity(sGravity, sXOffset, sYOffset);
        }
        if (sMsgTextSize != -1) {
            tvMessage.setTextSize(sMsgTextSize);
        }
        tvMessage.setTextColor(sMsgColor);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();


    }

    public static void setGravity(final int gravity, final int xOffset, final int yOffset) {
        sGravity = gravity;
        sXOffset = xOffset;
        sYOffset = yOffset;
    }

    public static void setBgColor(@ColorInt final int backgroundColor) {
        sBgColor = backgroundColor;
    }

    public static void setBgResource(@DrawableRes final int bgResource) {
        sBgResource = bgResource;
    }

    public static void setMsgColor(@ColorInt final int msgColor) {
        sMsgColor = msgColor;
    }

    public static void setMsgTextSize(final int textSize) {
        sMsgTextSize = textSize;
    }


    private static Context getApplicationContext() {
        if (null != applicationContext) {
            return applicationContext;
        }

        final Object activityThread = getActivityThread();
        if (null != activityThread) {
            try {
                final Method getApplication = activityThread.getClass().getDeclaredMethod("getApplication");
                getApplication.setAccessible(true);
                applicationContext = (Context) getApplication.invoke(activityThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return applicationContext;
    }

    private static Object getActivityThread() {
        try {
            final Class<?> clz = Class.forName("android.app.ActivityThread");
            final Method method = clz.getDeclaredMethod("currentActivityThread");
            method.setAccessible(true);
            final Object activityThread = method.invoke(null);
            return activityThread;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
