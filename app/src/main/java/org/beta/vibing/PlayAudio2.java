package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio2 extends Service {

    static MediaPlayer mCurrentPlayer2;
    static MediaPlayer mNextPlayer2 = null;

    static float volume2 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer2.create(this, R.raw.campfire);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio2.mCurrentPlayer2.stop();
        PlayAudio2.mCurrentPlayer2.release();
        PlayAudio2.mNextPlayer2.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer2 {

        private final Context mContext;
        private final int mResId;


        private static void create(Context context, int resId) {
            new LoopMediaPlayer2(context, resId);
        }

        private LoopMediaPlayer2(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer2 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer2.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer2.start();
                mCurrentPlayer2.setVolume(volume2,volume2);
            });

            createNextMediaPlayer2();
        }

        private void createNextMediaPlayer2() {
            mNextPlayer2 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer2.setNextMediaPlayer(mNextPlayer2);
            mCurrentPlayer2.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer2) {
                mediaPlayer2.release();
                mCurrentPlayer2 = mNextPlayer2;
                mCurrentPlayer2.setVolume(volume2,volume2);

                createNextMediaPlayer2();
            }
        };
    }

}