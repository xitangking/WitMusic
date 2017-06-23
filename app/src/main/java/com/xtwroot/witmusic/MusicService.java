package com.xtwroot.witmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/********************************************************************************
 * using for:
 * 丁酉鸡年四月 2017/06/23 22:02
 * @author 西唐王, xtwyzh@gmail.com,blog.xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class MusicService extends Service {

    private MediaPlayer mMediaPlayer;
    private LocalBinder mIBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this,R.raw.geweiyang);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mMediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {

        mMediaPlayer.stop();
        super.onDestroy();
    }

    public int getMusicPalyProgress() {

        return mMediaPlayer.getCurrentPosition();
    }

    public String getMusicName() {

        return mMediaPlayer.toString();
    }

    public class LocalBinder extends Binder {
        MusicService getService() { return MusicService.this; }
    }

}
