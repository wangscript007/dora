package dora;

import android.app.Application;
import android.content.Context;

/**
 * 继承这个类就相当于在AndroidManifest.xml中的application节点自动添加了
 * <metadata name="dora.DefaultGlobalConfig" value="GlobalConfig"/>
 */
public class BaseApplication extends Application {

    private ApplicationLifecycleCallbacks mAppDelegate;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null) {
            mAppDelegate = new AppDelegate(base);
        }
        mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppDelegate != null) {
            mAppDelegate.onCreate(this);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null) {
            mAppDelegate.onTerminate(this);
        }
    }
}
