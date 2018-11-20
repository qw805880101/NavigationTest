package com.example.tc.navigationtest;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

public class ToastUtil {

    private static final int CONTENT_CHAR_SEQUENCE = 1;
    private static final int CONTENT_STRING_ID = 2;

    private static Toast toast;

    private static Context mContext;

    private static Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == CONTENT_CHAR_SEQUENCE) {
                if (msg.obj instanceof CharSequence) {
                    doShowToast((CharSequence) (msg.obj));
                }
            } else if (msg.what == CONTENT_STRING_ID) {
                Context applicationContext = mContext;
                if (applicationContext == null) {
                    applicationContext = mContext;
                }
                doShowToast(applicationContext.getString((int) (msg.obj)));
            }
        }
    };

    public static void showToast(Context context, CharSequence text) {
        mContext = context;
        if (TextUtils.isEmpty(text))
            return;

        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        handler.sendMessage(handler.obtainMessage(CONTENT_CHAR_SEQUENCE, text));

    }

    public static void showToast(Context context, int resId) {
//        final Context applicationContext = MainApplication.getApplication();
//        showToast(applicationContext.getString(resId));

        if (toast != null) {
            toast.cancel();
        }

        handler.sendMessage(handler.obtainMessage(CONTENT_STRING_ID, resId));
    }

    private static void doShowToast(CharSequence text) {
        try { //TODO has already been added to the window manager. 多次点击闪退
            final Context applicationContext = mContext;
            final int textViewId = R.id.llloginsdk_toast_text;
            if (toast == null) {
//            DebugLog.e("pre make custom toast");
                toast = makeCustomToast(applicationContext, R.layout.normal_toast, textViewId, text);
//            DebugLog.e("after make custom toast");
            } else {
//            DebugLog.e("pre set custom toast");
                ((TextView) toast.getView().findViewById(textViewId)).setText(text);
                toast.setDuration(Toast.LENGTH_SHORT);
//            DebugLog.e("after set custom toast");
            }
            toast.show();
        } catch (Exception e) {
            toast = null;
        }
//        DebugLog.e("after show custom toast");
    }

    private static Toast makeCustomToast(Context context, @LayoutRes int layoutRes, @IdRes int textViewId, CharSequence text) {
        View layout = LayoutInflater.from(context).inflate(layoutRes, null);
        ((TextView) layout.findViewById(textViewId)).setText(text);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 32);
        toast.setDuration(Toast.LENGTH_LONG);
        if (toast.getView() == null)
            toast.setView(layout);
        return toast;
    }

}
