package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio10 extends Service {

    static MediaPlayer mCurrentPlayer10;
    static MediaPlayer mNextPlayer10 = null;

    static float volume10 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayAudio10.LoopMediaPlayer10.create(this, R.raw.rain);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio10.mCurrentPlayer10.stop();
        PlayAudio10.mCurrentPlayer10.release();
        PlayAudio10.mNextPlayer10.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer10 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new PlayAudio10.LoopMediaPlayer10(context, resId);
        }

        private LoopMediaPlayer10(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer10 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer10.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer10.start();
                mCurrentPlayer10.setVolume(volume10,volume10);
            });

            createNextMediaPlayer10();
        }

        private void createNextMediaPlayer10() {
            mNextPlayer10 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer10.setNextMediaPlayer(mNextPlayer10);
            mCurrentPlayer10.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer10) {
                mediaPlayer10.release();
                mCurrentPlayer10 = mNextPlayer10;
                mCurrentPlayer10.setVolume(volume10,volume10);

                createNextMediaPlayer10();
            }
        };
    }
}
