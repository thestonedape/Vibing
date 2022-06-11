package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio1 extends Service {

    static MediaPlayer mCurrentPlayer1;
    static MediaPlayer mNextPlayer1 = null;

    static float volume1 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer1.create(this, R.raw.bird);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio1.mCurrentPlayer1.stop();
        PlayAudio1.mCurrentPlayer1.release();
        PlayAudio1.mNextPlayer1.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer1 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new LoopMediaPlayer1(context, resId);
        }

        private LoopMediaPlayer1(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer1 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer1.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer1.start();
                mCurrentPlayer1.setVolume(volume1,volume1);
            });

            createNextMediaPlayer1();
        }

        private void createNextMediaPlayer1() {
            mNextPlayer1 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer1.setNextMediaPlayer(mNextPlayer1);
            mCurrentPlayer1.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer1) {
                mediaPlayer1.release();
                mCurrentPlayer1 = mNextPlayer1;
                mCurrentPlayer1.setVolume(volume1,volume1);

                createNextMediaPlayer1();
            }
        };
    }

}