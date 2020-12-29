package com.mars.framework_comutils_java;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * @author Mars
 * 控件点击事件工具类
 */
public class ViewOnClickerUtils {
    private static MyHandler handler;
    private Message message;
    private static ViewOnClickerUtils viewOnClickerUtils;
    private static Object object = new Object();
    public static ViewOnClickerUtils getInstance() {
        if (viewOnClickerUtils == null) {
            synchronized (object) {
                if (viewOnClickerUtils == null) {
                    viewOnClickerUtils = new ViewOnClickerUtils();
                    handler = new MyHandler(viewOnClickerUtils);
                }
            }
        }
        return viewOnClickerUtils;
    }

    private long lastClickTime;//记录最后点击的时间
    /**
     * 防重复点击 (true--重复点击，false--不是)
     * @param spaceTime 点击间隔时间（毫秒）
     * @return
     */
    public  boolean doubleOnclickAction(long spaceTime) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < spaceTime) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public void clearViewOnClickerUtils(){
        if(handler!=null){
            handler.removeCallbacks(null);
            handler = null;
        }
        if(viewOnClickerUtils != null){
            viewOnClickerUtils = null;
        }
    }


    /**
     * 防止重复点击
     *
     * @param view
     */
    public void doubleOnclickAction(Context mCtx, final View view) {
        if (!view.isEnabled()) {
            ToastManger.showToast(mCtx, "您的动作太快，我还没反应过来");
        }
        view.setEnabled(false);
        message = new Message();
        view.setEnabled(false);
        message.what = 0x01;
        message.obj = view;
        handler.sendMessageDelayed(message, Constant.ONCLICK_DELAY);
    }

    /**
     * 防止重复点击
     *
     * @param view
     */
    public void doubleOnclickAction(Context mCtx, final View view, long delayMillis) {
        if (!view.isEnabled()) {
            ToastManger.showToast(mCtx, "您的动作太快，我还没反应过来");
        }
        view.setEnabled(false);
        message = new Message();
        view.setEnabled(false);
        message.what = 0x01;
        message.obj = view;
        handler.sendMessageDelayed(message, delayMillis);
    }

    private static class MyHandler extends Handler {
        WeakReference<ViewOnClickerUtils> weakReference;

        public MyHandler(ViewOnClickerUtils weakReferenceFr) {
            weakReference = new WeakReference<>(weakReferenceFr);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ViewOnClickerUtils viewOnClickerUtils = weakReference.get();
            switch (msg.what) {
                case 0x01:
                    ((View) msg.obj).setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    }
}
