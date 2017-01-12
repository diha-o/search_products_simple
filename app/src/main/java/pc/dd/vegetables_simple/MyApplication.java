package pc.dd.vegetables_simple;

import android.app.Application;

/**
 * Created by User on 12.01.2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBSingleton.getInstance(this.getApplicationContext());
    }
}
