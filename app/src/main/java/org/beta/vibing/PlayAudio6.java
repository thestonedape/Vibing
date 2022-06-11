package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;




public class PlayAudio6 extends Service {

    static MediaPlayer mCurrentPlayer6;
    static MediaPlayer mNextPlayer6 = null;

    static float volume6 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer6.create(this, R.raw.coffee);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio6.mCurrentPlayer6.stop();
        PlayAudio6.mCurrentPlayer6.release();
        PlayAudio6.mNextPlayer6.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer6 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new LoopMediaPlayer6(context, resId);
        }

        private LoopMediaPlayer6(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer6 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer6.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer6.start();
                mCurrentPlayer6.setVolume(volume6,volume6);
            });

            createNextMediaPlayer6();
        }

        private void createNextMediaPlayer6() {
            mNextPlayer6 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer6.setNextMediaPlayer(mNextPlayer6);
            mCurrentPlayer6.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer6) {
                mediaPlayer6.release();
                mCurrentPlayer6 = mNextPlayer6;
                mCurrentPlayer6.setVolume(volume6,volume6);

                createNextMediaPlayer6();
            }
        };
    }

}