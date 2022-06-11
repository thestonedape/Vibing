package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio7 extends Service {

    static MediaPlayer mCurrentPlayer7;
    static MediaPlayer mNextPlayer7 = null;

    static float volume7 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayAudio7.LoopMediaPlayer7.create(this, R.raw.train);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio7.mCurrentPlayer7.stop();
        PlayAudio7.mCurrentPlayer7.release();
        PlayAudio7.mNextPlayer7.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer7 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new PlayAudio7.LoopMediaPlayer7(context, resId);
        }

        private LoopMediaPlayer7(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer7 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer7.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer7.start();
                mCurrentPlayer7.setVolume(volume7,volume7);
            });

            createNextMediaPlayer7();
        }

        private void createNextMediaPlayer7() {
            mNextPlayer7 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer7.setNextMediaPlayer(mNextPlayer7);
            mCurrentPlayer7.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer7) {
                mediaPlayer7.release();
                mCurrentPlayer7 = mNextPlayer7;
                mCurrentPlayer7.setVolume(volume7,volume7);

                createNextMediaPlayer7();
            }
        };
    }

}
