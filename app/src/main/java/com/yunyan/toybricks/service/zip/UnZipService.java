package com.yunyan.toybricks.service.zip;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yunyan.toybricks.entity.ToyBricksZipFile;
import com.yunyan.toybricks.utils.Const;

/**
 * Created by George on 2015/8/31.
 */
public class UnZipService extends Service{

    public final static String UNZIP_ACTION_START = "UNZIP_ACTION_START";
    public final static String UNZIP_ACTION_UPDATE = "UNZIP_ACTION_UPDATE";
    public final static String UNZIP_ACTION_FINISH = "UNZIP_ACTION_FINISH";
    public final static String UNZIP_ACTION_EXCEPTION = "UNZIP_ACTION_EXCEPTION";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent!=null){
            if (intent.getAction()!=null){
                if (UNZIP_ACTION_START.equals(intent.getAction())){
                    ToyBricksZipFile file =(ToyBricksZipFile)intent.getSerializableExtra(Const.UNZIP_KEY_INFO);
                    UnZipTask task=new UnZipTask(UnZipService.this,file);
                    task.UnZip();
                }else {
                    Log.e(UnZipService.class.getSimpleName(),"unknown action");
                }
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
