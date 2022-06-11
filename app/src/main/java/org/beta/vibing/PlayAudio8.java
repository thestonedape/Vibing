package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio8 extends Service {
    static MediaPlayer mCurrentPlayer8;
    static MediaPlayer mNextPlayer8 = null;

    static float volume8 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayAudio8.LoopMediaPlayer8.create(this, R.raw.piano);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio8.mCurrentPlayer8.stop();
        PlayAudio8.mCurrentPlayer8.release();
        PlayAudio8.mNextPlayer8.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer8 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new PlayAudio8.LoopMediaPlayer8(context, resId);
        }

        private LoopMediaPlayer8(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer8 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer8.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer8.start();
                mCurrentPlayer8.setVolume(volume8,volume8);
            });

            createNextMediaPlayer8();
        }

        private void createNextMediaPlayer8() {
            mNextPlayer8 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer8.setNextMediaPlayer(mNextPlayer8);
            mCurrentPlayer8.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer8) {
                mediaPlayer8.release();
                mCurrentPlayer8 = mNextPlayer8;
                mCurrentPlayer8.setVolume(volume8,volume8);

                createNextMediaPlayer8();
            }
        };
    }
}