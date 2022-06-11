package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;




public class PlayAudio5 extends Service {

    static MediaPlayer mCurrentPlayer5;
    static MediaPlayer mNextPlayer5 = null;

    static float volume5 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer5.create(this, R.raw.wind);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio5.mCurrentPlayer5.stop();
        PlayAudio5.mCurrentPlayer5.release();
        PlayAudio5.mNextPlayer5.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer5 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new LoopMediaPlayer5(context, resId);
        }

        private LoopMediaPlayer5(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer5 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer5.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer5.start();
                mCurrentPlayer5.setVolume(volume5,volume5);
            });

            createNextMediaPlayer5();
        }

        private void createNextMediaPlayer5() {
            mNextPlayer5 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer5.setNextMediaPlayer(mNextPlayer5);
            mCurrentPlayer5.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer5) {
                mediaPlayer5.release();
                mCurrentPlayer5 = mNextPlayer5;
                mCurrentPlayer5.setVolume(volume5,volume5);

                createNextMediaPlayer5();
            }
        };
    }

}